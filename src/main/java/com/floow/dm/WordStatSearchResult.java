package com.floow.dm;
import java.util.*;

public class WordStatSearchResult extends AbstractSearchResult {
	
	
	private Map<String, Integer> leastCommonWords = new HashMap<String, Integer>();
	
	private Map<String, Integer> mostCommonWords = new HashMap<String, Integer>();
	
	private Map<String, Integer> longestWords = new HashMap<String, Integer>();
	
	private Map<String, Integer> shortestWords = new HashMap<String, Integer>();
	
	private long totalWords;
	
	private String filter;
	
	private int numLetters;
	
	
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
		this.filter = filter;
		this.numLetters = numLetters;
	}
	
}
