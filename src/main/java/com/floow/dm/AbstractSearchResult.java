package com.floow.dm;
import java.util.Map;

public abstract class AbstractSearchResult {

	// milliseconds of time taken to perform this search 
	long searchTime;
	
	public AbstractSearchResult(long searchTime) {
		this.searchTime = searchTime;
	}
	
	public abstract Map<String, Integer> getLeastCommonWords();

	public abstract void setLeastCommonWords(Map<String, Integer> leastCommonWords);

	public abstract Map<String, Integer> getMostCommonWords();

	public abstract void setMostCommonWords(Map<String, Integer> mostCommonWords);
	
	public abstract Map<String, Integer> getLongestWords();
	
	public abstract void setLongestWords(Map<String, Integer> longestWords);

	public abstract Map<String, Integer> getShortestWords(); 

	public abstract void setShortestWords(Map<String, Integer> shortestWords);
	
	public abstract long getTotalWords();
	
	public abstract void setTotalWords(long totalWords);
	
	public abstract String getFilter();
	
	public abstract void setFilter(String filter);
	
	public abstract Integer getNumLetters();
	
	public abstract void setNumLetters(Integer numLetters);
	
}
