package com.floow.services;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.List;
import com.floow.dao.WordsStatJobsDao;
import com.floow.dao.JobHistoryDao;
import com.floow.dm.*;
import com.floow.exceptions.*;
import org.apache.log4j.Logger;


/**
 * Service to perform statistical word searches on the content of the given file 
 */
public class WordStatSearchService extends AbstractService {

	private Logger log = Logger.getLogger(WordStatSearchService.class.getName());
	
	private static final boolean MAXIMUM_VALUES = true;
	private static final boolean MINIMUM_VALUES = false;

	
	private WordStatJobsCollatorService collatorService;
	
	// setup daos
	private DaoAccess daoAccess;
	private WordsStatJobsDao wordsStatJobsDao;
	private JobHistoryDao jobHistoryDao;
	
	
	public WordStatSearchService(int port, String hostname, String fileName) {
		super(fileName);
		daoAccess = new DaoAccess(port, hostname);
		wordsStatJobsDao = new WordsStatJobsDao(daoAccess);
		jobHistoryDao = new JobHistoryDao(daoAccess);
		
		collatorService = new WordStatJobsCollatorService(daoAccess, fileName);
	}
	
	
	public AbstractSearchResult performMaximumSearch(String filter, Integer numLetters) throws FailedSearchException {
		return performSearch(filter, numLetters, Arrays.asList(WordSearchType.values()));
	}
		
	
	
	protected AbstractSearchResult performSearch(String filter, Integer numLetters, List<WordSearchType> srchTypes) 
																				throws FailedSearchException {
		// TODO get Max from properties
		final long MAX_PROCESSING_TIME = 120000;

		String searchId = UUID.randomUUID().toString();
		long startTime = System.currentTimeMillis();

		try {			
			AbstractSearchResult distributedSearch = doDistributedSearch(searchId, filter, numLetters, srchTypes);
			
			
//			long timeTaken = 0l;
//			while (timeElapsed < MAX_PROCESSING_TIME) {
//				Thread.sleep(3000);
//				boolean searchComplete = searchCompleted(numOfJobs, searchId);
			
			
//				if (searchComplete) {
					// timeTaken = distributedSearch.getStartTime() - System.currentTimeMillis();
		            // distributedSearch.setTimetaken(timetaken);
//					return collateResults(distributedSearch);
//				}
//			}
			
			System.out.println("Number of jobs created: " + distributedSearch.getTotalJobs());
			
			//return new WordStatSearchResult(String searchId, long searchTime, int totalJobs);
			
			
		} catch(Exception e) {
			log.info("Exception thrown attempting to perform file search", e);
			throw new FailedSearchException("A " + e.getClass().getName() + " has occurred processing the file: " + getFileName() + 
					". Original message: " + e.getMessage()); 
		} 

		// the max processing time has been exceeded so abort this unsuccessful search
		throw new FailedSearchException("Search has been cancelled as it did not complete within " 
						+ MAX_PROCESSING_TIME / 1000 + " seconds");
	}
	
	
	
	// initiates a search
	protected AbstractSearchResult doDistributedSearch(String searchId, String filter, Integer numLetters, List<WordSearchType> srchTypes) throws FailedSearchException, IOException {
		// setup thread pool
		int cores = Runtime.getRuntime().availableProcessors(); // 4
		int threadPoolSize = cores > 2 ? cores - 2 : 1 ; // note that the JMS queue will be on 1 core, and this class on another..... 
		                                                 // no point on doing CPU work on more threads than there are CPUs 
		ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
		
		// setup channel
		FileInputStream fileInputStream = new FileInputStream(getFileName());
	    FileChannel channel = fileInputStream.getChannel();
	    long fileSize = channel.size(); 
	    
	    // set pre-jobs distribution properties
	    long startTime = System.currentTimeMillis();
	    int numJobs = 0; 
	    long offsetPosition = 0;
		int chunkSize = 1000000;  // TODO  PUT THIS IN A PROPERTIES FILE
		
	    // request distributed jobs to read the file content in bite-sized chunks
	    while (offsetPosition <= fileSize)
	    {
	    	// update the sequence / job id
	    	numJobs++;
	    	
	    	// allocate memory for this readable chunk
	        ByteBuffer buff = ByteBuffer.allocate(chunkSize);
	        
	        // read file chunk to buff in RAM
	        channel.read(buff, offsetPosition);

	        // process the readable chunk in a separate thread 
	        executor.execute(new SearchJobRequest(searchId, String.valueOf(numJobs), filter, numLetters, buff, srchTypes, daoAccess));
	        
	        // get the next read position in the file
	        offsetPosition = offsetPosition + chunkSize;
	    }
	    
	    // closing tasks
		fileInputStream.close();
	    long timeTaken = System.currentTimeMillis() - startTime;
	    log.info("Time taken to set up all producer threads with their buffer = " + timeTaken / 1000);
	    awaitTerminationAfterShutdown(executor);
		
		return new WordStatSearchResult(searchId, startTime, numJobs, filter, numLetters, srchTypes);
	}
     
	
/*  RESULTS: 
    
    PRODUCING STRING WITHOUT INVOKING THREAD
    String of 1,000,000 = total seconds = 71 
    String of 1,000,000 = total seconds = 39
    String of 100,000 = total seconds = 39
    
    
    PASSING BUFFER TO NEW THREAD ONLY
    String of 100,000 = total seconds = 40
    String of 1,000,000 = total seconds = 30!! 
    
    */
	
	
	protected void awaitTerminationAfterShutdown(ExecutorService threadPool) {
	    threadPool.shutdown();
	    try {
	        if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
	            threadPool.shutdownNow();
	        }
	    } catch (InterruptedException ex) {
	        threadPool.shutdownNow();
	    }
	}
	
	
	
	// TODO get the results  FOR NOW COLLATE ALL THE RESULTS 
	protected AbstractSearchResult collateResults(AbstractSearchResult resultData)  {
		String searchId = resultData.getSearchId();
		String filter = resultData.getFilter();
		Integer numLetters = resultData.getNumLetters();
		WordStatSearchResult populatedResults = (WordStatSearchResult) resultData;
		
		// collate the search results of all the services [NOTES THIS SEARCHES FOR ALL WordSearchTypes!!]
		Map<String, Long> wordToOccurrMax = collatorService.findWordsToNumberOfOccurrences(searchId, filter, numLetters, MAXIMUM_VALUES);
		Map<String, Long> wordToOccurrMin = collatorService.findWordsToNumberOfOccurrences(searchId, filter, numLetters, MINIMUM_VALUES);
		Map<Long, String> numLettersToWordMax = collatorService.findNumberOfLettersForWords(searchId, filter, MAXIMUM_VALUES);
		Map<Long, String> numLettersToWordMin = collatorService.findNumberOfLettersForWords(searchId, filter, MINIMUM_VALUES);
		long totalWords = collatorService.findTotalWords(searchId, filter, numLetters);

		populatedResults.setWordToOccurrMax(wordToOccurrMax);
		populatedResults.setWordToOccurrMin(wordToOccurrMin);
		populatedResults.setNumLettersToWordMax(numLettersToWordMax);
		populatedResults.setNumLettersToWordMin(numLettersToWordMin);
		populatedResults.setTotalWords(totalWords);
		
		return populatedResults;
	}
	
	
	
	
	
	// TODO NOTE THAT THE FIRST JOB ON GETTING THE RESULT LIST IS TO CALCULTATE the last words, other than seq 1, and first words of each job
	// TODO then add this to the result
	protected boolean searchCompleted(int numOfJobs, String searchId) throws FailedSearchException {
		List<JobHistory> srchJobs = jobHistoryDao.findJobRecords(searchId);  

		boolean srchComplete = true;
		
		// TODO convert to JAVA 8!!
		if (srchJobs != null && srchJobs.size() > 0 && srchJobs.size() == numOfJobs) {
			for (JobHistory job : srchJobs) {
				if (job.getStatus().getId() == SearchJobStatus.FAILED.getId()) {
					throw new FailedSearchException("Search failed on job: " + job.getStatus().getId());
				}
				
				if (job.getStatus().getId() != SearchJobStatus.COMPLETED.getId()) {
					return false;
				}
			}
		} 
		
		return true;
	}
	
	
	
	public File getFile() throws FailedSearchException {
		File file = new File(getFileName());
		System.out.println("File input size: " + file.length() + " bytes");
		if (file.length() == 0) {
			throw new FailedSearchException("File " + getFileName() + " cannot be found or is empty");
		}

		return file;
	}
		
	
}
