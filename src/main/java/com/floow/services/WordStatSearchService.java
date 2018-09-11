package com.floow.services;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.List;
import com.floow.client.ClientManager;
import com.floow.dm.*;
import com.floow.exceptions.*;
import org.apache.log4j.Logger;


public class WordStatSearchService extends AbstractService {

	private Logger log = Logger.getLogger(WordStatSearchService.class.getName());
	
	public WordStatSearchService(int port, String hostname, String fileName) {
		super(new DaoAccess(port, hostname, fileName));
	}
	

	public AbstractSearchResult getMostAndLeastCommonWords() throws FailedSearchException {
		List<WordSearchType> srchTypes = new ArrayList<WordSearchType>();
		srchTypes.add(WordSearchType.MOST_COMMON_WORD);
		srchTypes.add(WordSearchType.LEAST_COMMON_WORD);
		return performSearch(null, null, srchTypes);
		
//		Map<String, Integer> leastCommonWords = new HashMap<String, Integer>();
//		leastCommonWords.put("curiosity", 1);
//		leastCommonWords.put("triviality", 3);
//		leastCommonWords.put("pomposity", 3);
//		leastCommonWords.put("oddly", 4);
//		leastCommonWords.put("googly", 4);		
//		Map<String, Integer> mostCommonWords = new HashMap<String, Integer>();
//		mostCommonWords.put("curiosity", 1);
//		mostCommonWords.put("triviality", 3);
//		mostCommonWords.put("pomposity", 3);
//		mostCommonWords.put("oddly", 4);
//		mostCommonWords.put("googly", 4);
//		WordStatSearchResult result = new WordStatSearchResult(4000l); 
//		result.setLeastCommonWords(leastCommonWords);
//		result.setMostCommonWords(mostCommonWords);
//		return result;		
	}
	

	
	
	public AbstractSearchResult getMostAndLeastCommonWords(String filter, Integer numLetters) throws FailedSearchException {
//		List<WordSearchType> srchTypes = new ArrayList<WordSearchType>();
//		
//		if (StringUtils.isBlank(filter)) {
//			srchTypes.add(WordSearchType.MOST_COMMON_WORD);
//			srchTypes.add(WordSearchType.LEAST_COMMON_WORD);
//		} else {
//			srchTypes.add(WordSearchType.MOST_COMMON_WORD_WITH_FILTER);
//			srchTypes.add(WordSearchType.LEAST_COMMON_WORD_WITH_FILTER);
//		}
//		
//		if (numLetters != null && numLetters.intValue() <= 0 ) {
//			throw new FailedSearchException("Number of letters must be a positive number, but was: " + numLetters);
//		}
//		
//		if (numLetters != null) { 
//			srchTypes.add(WordSearchType.MOST_COMMON_WORD_OF_N_LETTERS);
//			srchTypes.add(WordSearchType.LEAST_COMMON_WORD_OF_N_LETTERS);
//		}
//
//		return performSearch(filter, numLetters, srchTypes);

		//		// DUMMY HERE
		Map<String, Integer> leastCommonWords = new HashMap<String, Integer>();
		leastCommonWords.put("curiosity", 1);
		leastCommonWords.put("triviality", 3);
		leastCommonWords.put("pomposity", 3);
		leastCommonWords.put("oddly", 4);
		leastCommonWords.put("googly", 4);		
		Map<String, Integer> mostCommonWords = new HashMap<String, Integer>();
		mostCommonWords.put("curiosity", 1);
		mostCommonWords.put("triviality", 3);
		mostCommonWords.put("pomposity", 3);
		mostCommonWords.put("oddly", 4);
		mostCommonWords.put("googly", 4);
		WordStatSearchResult result = new WordStatSearchResult(4000l); 
		result.setLeastCommonWords(leastCommonWords);
		result.setMostCommonWords(mostCommonWords);
		return result;
	}
	
	
	
	public AbstractSearchResult getLongestAndShortestWords(String filter) throws FailedSearchException {
//		List<WordSearchType> srchTypes = new ArrayList<WordSearchType>();
//		if (StringUtils.isBlank(filter)) {
//			srchTypes.add(WordSearchType.LONGEST_WORD);
//			srchTypes.add(WordSearchType.SHORTEST_WORD);
//
//		} else {
//			srchTypes.add(WordSearchType.LONGEST_WORD_WITH_FILTER);
//			srchTypes.add(WordSearchType.SHORTEST_WORD_WITH_FILTER);
//		}
//		
//		return performSearch(filter, null, srchTypes);
		
		// DUMMY HERE
		WordStatSearchResult result = new WordStatSearchResult(4003l);
		Map<String, Integer> longestWords = new HashMap<String, Integer>();
		longestWords.put("sdfsdfsdfsdfwsfsddfwerwerwefsdfsdfsfsdfsdfsdfsfsfsfsdfsdf", 30);
		longestWords.put("fsdfsdfsdfsdfsdfsdfsdfsddfsfsdfsdfsfdsdfsdfsdfs", 23);
		longestWords.put("zcxzxczxczxczxczxczxxczczczxczxczxczxczxczx", 19);
		result.setLongestWords(longestWords);
		Map<String, Integer> shortestWords = new HashMap<String, Integer>();
		shortestWords.put("a", 1);
		shortestWords.put("i", 1);
		result.setShortestWords(shortestWords);
		return result;
	}
	
	
	
	
	public AbstractSearchResult getTotalWords(String filter, Integer numLetters) throws FailedSearchException {
//		List<WordSearchType> srchTypes = new ArrayList<WordSearchType>();
//		if (StringUtils.isBlank(filter)) {
//			srchTypes.add(WordSearchType.TOTAL_WORDS);
//		} else {
//			srchTypes.add(WordSearchType.TOTAL_WORDS_WITH_FILTER);
//		}
//		
//		if (numLetters != null && numLetters.intValue() <= 0 ) {
//			throw new FailedSearchException("Number of letters must be a positive number, but was: " + numLetters);
//		}
//		
//		if (numLetters != null) { 
//			srchTypes.add(WordSearchType.TOTAL_WORDS_OF_N_LETTERS);
//		}
//
//		return performSearch(filter, numLetters, srchTypes);
		
		WordStatSearchResult result = new WordStatSearchResult(4008l);
		result.setTotalWords(90000345l);
		result.setFilter(filter);
		result.setNumLetters(numLetters);
		return result;
	}
	
	
		
	////////////////////////////////////////////////////
	
	
	private AbstractSearchResult performSearch(String filter, Integer numLetters, List<WordSearchType> srchTypes) 
																				throws FailedSearchException {
		// TODO get Max from properties
		final long MAX_PROCESSING_TIME = 120000;

		String searchId = UUID.randomUUID().toString();
		long startTime = System.currentTimeMillis();

		try {			
			int numOfJobs = doDistributedSearch(searchId, filter, numLetters, srchTypes);
			
//			long timeElapsed = 0l;
//			while (timeElapsed < MAX_PROCESSING_TIME) {
//				Thread.sleep(3000);
//				boolean searchComplete = searchCompleted(numOfJobs, searchId);
//				timeElapsed = startTime - System.currentTimeMillis();
//				if (searchComplete) {
//					return collateResults(searchId, srchTypes, timeElapsed);
//				}
//			}
			
			System.out.println("Number of jobs created: " + numOfJobs);
			
		} catch(Exception e) {
			log.info("Exception thrown attempting to perform file search", e);
			throw new FailedSearchException("A " + e.getClass().getName() + " has occurred processing the file: " + dao.getFileName() + 
					". Original message: " + e.getMessage()); 
		} 

		// the max processing time has been exceeded so abort this unsuccessful search
		throw new FailedSearchException("Search has been cancelled as it did not complete within " 
						+ MAX_PROCESSING_TIME / 1000 + " seconds");
	}
	
		
	
	// initiates a search
	private int doDistributedSearch(String searchId, String filter, Integer numLetters, List<WordSearchType> srchTypes) throws FailedSearchException, IOException {
		// setup thread pool
		int cores = Runtime.getRuntime().availableProcessors(); // 4
		int threadPoolSize = cores > 2 ? cores - 2 : 1 ; // note that the JMS queue will be on 1 core, and this class on another..... 
		                                                 // no point on doing CPU work on more threads than there are CPUs 
		ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
		
		// setup channel
		FileInputStream fileInputStream = new FileInputStream(dao.getFileName());
	    FileChannel channel = fileInputStream.getChannel();
	    long fileSize = channel.size(); 
	    
	    // set pre-jobs distribution properties
	    long startTime = System.currentTimeMillis();
	    int seq = 0; 
	    long offsetPosition = 0;
		int chunkSize = 1000000;  // TODO  PUT THIS IN A PROPERTIES FILE
		
	    // request distributed jobs to read the file content in bite-sized chunks
	    while (offsetPosition <= fileSize)
	    {
	    	// update the sequence / job id
	    	seq++;
	    	
	    	// allocate memory for this readable chunk
	        ByteBuffer buff = ByteBuffer.allocate(chunkSize);
	        
	        // read file chunk to buff in RAM
	        channel.read(buff, offsetPosition);

	        // process the readable chunk in a separate thread 
	        executor.execute(new SearchJobRequest(searchId, String.valueOf(seq), filter, numLetters, buff, srchTypes, dao));
	        
	        // get the next read position in the file
	        offsetPosition = offsetPosition + chunkSize;
	    }
	    
	    // closing tasks
		fileInputStream.close();
	    long timeTaken = System.currentTimeMillis() - startTime;
	    log.info("Time taken to set up all producer threads with their buffer = " + timeTaken / 1000);
	    awaitTerminationAfterShutdown(executor);
		
		return seq;
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
	
	
	private void awaitTerminationAfterShutdown(ExecutorService threadPool) {
	    threadPool.shutdown();
	    try {
	        if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
	            threadPool.shutdownNow();
	        }
	    } catch (InterruptedException ex) {
	        threadPool.shutdownNow();
	        // Thread.currentThread().interrupt();
	    }
	}
	
	
	
	// TODO get the results
	private AbstractSearchResult collateResults(String searchId, List<WordSearchType> srchTypes, long timeElapsed)  {
		
		WordStatSearchResult srchResult = new WordStatSearchResult(timeElapsed);
		
		/* SWITCH to build up data
		   MOST_LEAST_COMMON
	           MOST_LEAST_COMMON_WITH_FILTER
	           MOST_LEAST_COMMON_OF_N_LETTERS
	           LONGEST_SHORTEST
	           LONGEST_SHORTEST_WITH_FILTER
	           TOTAL_WORDS
	           TOTAL_WORDS_WITH_FILTER  
	           TOTAL_WORDS_OF_N_LETTERS
		 */
		
		
		
		/*
		 WordStatSearchResult(long searchTime, Map<String, Integer> leastCommonWords,
			Map<String, Integer> mostCommonWords, Map<String, Integer> longestWords, Map<String, Integer> shortestWords,
			long totalWords, String filter, int numLetters) 
		 */
		
		return srchResult;
	}
	
	
	
	
	
	// TODO NOTE THAT THE FIRST JOB ON GETTING THE RESULT LIST IS TO CALCULTATE the last words, other than seq 1, and first words of each job
	// TODO then add this to the result
	private boolean searchCompleted(int numSrchParts, String searchId) throws FailedSearchException {
		
		// TODO GET THIS FROM DAO !!!!!
		List<JobHistory> jobList = null;  

		// TODO convert to JAVA 8!!
		if (jobList != null && jobList.size() > 0) {
			boolean srchComplete = true;
			for (JobHistory job : jobList) {
				if (job.getStatus().getId() == SearchJobStatus.FAILED.getId()) {
					throw new FailedSearchException("Search failed on job: " + job.getStatus().getId());
				}
				
				if (job.getStatus().getId() != SearchJobStatus.COMPLETED.getId()) {
					srchComplete = false;
				}
			}
			
			if (srchComplete && jobList.size() == numSrchParts) {
				return true;
			}
		} 
		
		return false;
	}
	
	
	
	public File getFile() throws FailedSearchException {
		File file = new File(dao.getFileName());
		System.out.println("File input size: " + file.length() + " bytes");
		if (file.length() == 0) {
			throw new FailedSearchException("File " + dao.getFileName() + " cannot be found or is empty");
		}

		return file;
	}
		
	
}
