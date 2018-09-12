package com.floow.dm;

import java.util.List;

/**
 * Abstract class to record the generic results of a statistical word search on a file.
 */
public abstract class AbstractSearchResult {

	private long timetaken;
	
	private long startTime;
	
	private String searchId;
	
	// number of jobs used to perform this search
	private int totalJobs;
	
	// search arguments 
	private String filter;
	private Integer numLetters;
	private List<WordSearchType> srchTypes;
		
	public AbstractSearchResult(String searchId, long startTime, int totalJobs, String filter, 
			Integer numLetters, List<WordSearchType> srchTypes) {
		this.startTime = startTime;
	}

	public long getTimetaken() {
		return timetaken;
	}

	public void setTimetaken(long timetaken) {
		this.timetaken = timetaken;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public Integer getNumLetters() {
		return numLetters;
	}

	public void setNumLetters(Integer numLetters) {
		this.numLetters = numLetters;
	}

	public List<WordSearchType> getSrchTypes() {
		return srchTypes;
	}

	public void setSrchTypes(List<WordSearchType> srchTypes) {
		this.srchTypes = srchTypes;
	}

	public int getTotalJobs() {
		return totalJobs;
	}

	public void setTotalJobs(int totalJobs) {
		this.totalJobs = totalJobs;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
}
