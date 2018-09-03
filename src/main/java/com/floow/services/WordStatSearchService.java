package com.floow.services;
import java.util.HashMap;
import java.util.Map;

import com.floow.dm.AbstractSearchResult;
import com.floow.dm.DaoAccess;
import com.floow.dm.WordStatSearchResult;

public class WordStatSearchService extends AbstractService {

	public WordStatSearchService(int port, String hostname, String filePath) {
		super(new DaoAccess(port, hostname, filePath));
		
		
		
		
	}
	

	public AbstractSearchResult getMostAndLeastCommonWords(String filter, int numLetters) {
		
		// DUMMY HERE
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
	
	
	public AbstractSearchResult getLongestWords(String filter) {
		
		// DUMMY HERE
		Map<String, Integer> longestWords = new HashMap<String, Integer>();
		longestWords.put("sdfsdfsdfsdfwsfsddfwerwerwefsdfsdfsfsdfsdfsdfsfsfsfsdfsdf", 30);
		longestWords.put("fsdfsdfsdfsdfsdfsdfsdfsddfsfsdfsdfsfdsdfsdfsdfs", 23);
		longestWords.put("zcxzxczxczxczxczxczxxczczczxczxczxczxczxczx", 19);
		WordStatSearchResult result = new WordStatSearchResult(4002l); 
		result.setLongestWords(longestWords);
		return result;
	}

	
	public AbstractSearchResult getShortestWords(String filter) {
		
		// DUMMY HERE
		Map<String, Integer> shortestWords = new HashMap<String, Integer>();
		shortestWords.put("a", 1);
		shortestWords.put("i", 1);
		WordStatSearchResult result = new WordStatSearchResult(4003l); 
		result.setShortestWords(shortestWords);
		return result;
	}
	
	
	public AbstractSearchResult getTotalWords(String filter, int numLetters) {
		WordStatSearchResult result = new WordStatSearchResult(4008l);
		result.setTotalWords(90000345l);
		result.setTotalWordsFilter(null);
		result.setTotalWordsNumLetters(null);
		return result;
	}
		
	
}
