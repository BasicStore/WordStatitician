package com.floow.dm;

public abstract class AbstractSearchResult {

	// milliseconds of time taken to perform this search 
	long searchTime;
	
	public AbstractSearchResult(long searchTime) {
		this.searchTime = searchTime;
	}
	
}
