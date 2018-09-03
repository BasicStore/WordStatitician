package com.floow.dm;
import java.util.*;

public class WordStatSearchResult extends AbstractSearchResult {
	
	
	private Map<String, Integer> leastCommonWords = new HashMap<String, Integer>();
	
	private Map<String, Integer> mostCommonWords = new HashMap<String, Integer>();
	
	private Map<String, Integer> longestWords = new HashMap<String, Integer>();
	
	private Map<String, Integer> shortestWords = new HashMap<String, Integer>();
	
	private long totalWords;
	
	private String totalWordsFilter;
	
	private Integer totalWordsNumLetters;
	
	
	public WordStatSearchResult(long searchTime) {
		super(searchTime);
	}


	public WordStatSearchResult(long searchTime, Map<String, Integer> leastCommonWords,
			Map<String, Integer> mostCommonWords, Map<String, Integer> longestWords, Map<String, Integer> shortestWords,
			long totalWords, String filter, int numLetters) {
		super(searchTime);
		this.leastCommonWords = leastCommonWords;
		this.mostCommonWords = mostCommonWords;
		this.longestWords = longestWords;
		this.shortestWords = shortestWords;
		this.totalWords = totalWords;
		this.totalWordsFilter = filter;
		this.totalWordsNumLetters = numLetters;
	}


	public Map<String, Integer> getLeastCommonWords() {
		return leastCommonWords;
	}


	public void setLeastCommonWords(Map<String, Integer> leastCommonWords) {
		this.leastCommonWords = leastCommonWords;
	}


	public Map<String, Integer> getMostCommonWords() {
		return mostCommonWords;
	}


	public void setMostCommonWords(Map<String, Integer> mostCommonWords) {
		this.mostCommonWords = mostCommonWords;
	}


	public Map<String, Integer> getLongestWords() {
		return longestWords;
	}


	public void setLongestWords(Map<String, Integer> longestWords) {
		this.longestWords = longestWords;
	}


	public Map<String, Integer> getShortestWords() {
		return shortestWords;
	}


	public void setShortestWords(Map<String, Integer> shortestWords) {
		this.shortestWords = shortestWords;
	}


	public long getTotalWords() {
		return totalWords;
	}


	public void setTotalWords(long totalWords) {
		this.totalWords = totalWords;
	}


	public String getTotalWordsFilter() {
		return totalWordsFilter;
	}


	public void setTotalWordsFilter(String totalWordsFilter) {
		this.totalWordsFilter = totalWordsFilter;
	}


	public Integer getTotalWordsNumLetters() {
		return totalWordsNumLetters;
	}


	public void setTotalWordsNumLetters(Integer totalWordsNumLetters) {
		this.totalWordsNumLetters = totalWordsNumLetters;
	}

	
}
