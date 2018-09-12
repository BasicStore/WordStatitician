package com.floow.dm;
import java.util.*;

/**
 * Class containing the results of a statistical word search on a file.
 * This class contains the results of the entire search.
 */
public class WordStatSearchResult extends AbstractSearchResult {
		
	private Map<String, Long> wordToOccurrMax;
	private Map<String, Long> wordToOccurrMin;
	private Map<Long, String> numLettersToWordMax;
	private Map<Long, String> numLettersToWordMin;
	private long totalWords;
	
	
	public WordStatSearchResult(String searchId, long startTime, int totalJobs, String filter, Integer numLetters, List<WordSearchType> srchTypes) {
		super(searchId, startTime, totalJobs, filter, numLetters, srchTypes);
	}


	public Map<String, Long> getWordToOccurrMax() {
		return wordToOccurrMax;
	}


	public void setWordToOccurrMax(Map<String, Long> wordToOccurrMax) {
		this.wordToOccurrMax = wordToOccurrMax;
	}


	public Map<String, Long> getWordToOccurrMin() {
		return wordToOccurrMin;
	}


	public void setWordToOccurrMin(Map<String, Long> wordToOccurrMin) {
		this.wordToOccurrMin = wordToOccurrMin;
	}


	public Map<Long, String> getNumLettersToWordMax() {
		return numLettersToWordMax;
	}


	public void setNumLettersToWordMax(Map<Long, String> numLettersToWordMax) {
		this.numLettersToWordMax = numLettersToWordMax;
	}


	public Map<Long, String> getNumLettersToWordMin() {
		return numLettersToWordMin;
	}


	public void setNumLettersToWordMin(Map<Long, String> numLettersToWordMin) {
		this.numLettersToWordMin = numLettersToWordMin;
	}


	public long getTotalWords() {
		return totalWords;
	}


	public void setTotalWords(long totalWords) {
		this.totalWords = totalWords;
	}
	
}
