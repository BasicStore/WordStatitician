package com.floow.services;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.List;
import com.floow.dm.*;
import com.floow.exceptions.*;


public class WordStatSearchService extends AbstractService {

	private File file;
	
	public WordStatSearchService(int port, String hostname, String fileName) {
		super(new DaoAccess(port, hostname, fileName));
	}
	

	public AbstractSearchResult getMostAndLeastCommonWords() throws FailedSearchException {
//		List<WordSearchType> srchTypes = new ArrayList<WordSearchType>();
//		srchTypes.add(WordSearchType.MOST_COMMON_WORD);
//		srchTypes.add(WordSearchType.LEAST_COMMON_WORD);
//		return performSearch(null, null, srchTypes);
		
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
			String[] searchParts = initSearch(searchId, filter, numLetters, srchTypes);
			long timeElapsed = 0l;
			while (timeElapsed < MAX_PROCESSING_TIME) {
				Thread.sleep(4000l);
				boolean searchComplete = searchCompleted(searchParts.length, searchId);
				timeElapsed = startTime - System.currentTimeMillis();
				if (searchComplete) {
					return calculateResults(searchId, srchTypes, timeElapsed);
				}
			}
			
		} catch(Exception e) {
			throw new FailedSearchException("A " + e.getClass().getName() + " has occurred processing the file: " + dao.getFileName() + 
					". Original message: " + e.getMessage()); 
		} 

		// the max processing time has been exceeded so abort this unsuccessful search
		throw new FailedSearchException("Search has been cancelled as it did not complete within " 
						+ MAX_PROCESSING_TIME / 1000 + " seconds");
	}
	
	
	
	// initiates a search
	private String[] initSearch(String searchId, String filter, Integer numLetters, List<WordSearchType> srchTypes) throws FailedSearchException, IOException {
	
		File file = getFile(); 
		long fileSize = file.length();	
		
		// TODO REMOVE this is only an example
		FileInputStream fileInputStream = new FileInputStream(dao.getFileName());
		fileInputStream.close();
		
		// TODO generate this
		Map<Long, Long> segmentMap = new HashMap<Long, Long>();
		segmentMap.put(1l, 99999l);
		segmentMap.put(100000l, 199999l);
		segmentMap.put(200000l, 299999l);
		segmentMap.put(300000l, 399999l);
		segmentMap.put(400000l, 499999l);
		
		String[] jobIds = new String[segmentMap.size()];
		int count = 0;
		
		for (long key : segmentMap.keySet()) {
			jobIds[count] = UUID.randomUUID().toString(); 
			
			long startByte = key;
			long endByte = segmentMap.get(key);
			
			// TODO ouiyiuiuyi
			FileInputStream filePart = null; 
			
			JobHistory jobRecord = new JobHistory(searchId, jobIds[count], null, SearchJobStatus.PROCESSING);
			// TODO send overview to database
			
			SearchStreamJobRequest jobReq = new SearchStreamJobRequest(searchId, jobIds[count], startByte, endByte, filter, 
					numLetters, filePart, dao);
			// TODO send to JMS queue or database
			
			count++;
		}
		
		return jobIds;
	}
            
	
	
	
	// TODO get the results
	private AbstractSearchResult calculateResults(String searchId, List<WordSearchType> srchTypes, long timeElapsed)  {
		
		/*
		   MOST_LEAST_COMMON
	           MOST_LEAST_COMMON_WITH_FILTER
	           MOST_LEAST_COMMON_OF_N_LETTERS
	           LONGEST_SHORTEST
	           LONGEST_SHORTEST_WITH_FILTER
	           TOTAL_WORDS
	           TOTAL_WORDS_WITH_FILTER  
	           TOTAL_WORDS_OF_N_LETTERS
		 */

		
		// TODO generate this from database
		WordStatSearchResult srchResult = new WordStatSearchResult(timeElapsed, null, null, null, null, null, null, null);
		
		
		/*
		 WordStatSearchResult(long searchTime, Map<String, Integer> leastCommonWords,
			Map<String, Integer> mostCommonWords, Map<String, Integer> longestWords, Map<String, Integer> shortestWords,
			long totalWords, String filter, int numLetters) 
		 */
		
		
		/*
		 ==> IF there are FAILED, return FailedSearchException 
		           with reason in ProcessFileSegmentRequest.failureReason 
		 */
		
		
		
		return srchResult;
	}
	
	
	
	
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
	
	
	
	private File getFile() throws FailedSearchException {
		file = new File(dao.getFileName());
		System.out.println("File input size: " + file.length() + " bytes");
		if (file.length() == 0) {
			throw new FailedSearchException("File " + dao.getFileName() + " cannot be found or is empty");
		}

		return file;
	}
		
	
}
