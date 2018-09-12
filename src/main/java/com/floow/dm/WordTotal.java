package com.floow.dm;

public class WordTotal extends AbstractJobResult {

	private long numWords; 
	private String filter; 
	private int numLetters;	
	
	public WordTotal(String jobid, long numWords, String filter, int numLetters) {
		super(jobid);
		this.numWords = numWords;
		this.filter = filter;
		this.numLetters = numLetters;
	}
	
	
	public WordTotal(String searchId, String jobid, long numWords, String filter, int numLetters, long jobtime) {
		super(searchId, jobid, jobtime);
		this.numWords = numWords;
		this.filter = filter;
		this.numLetters = numLetters;
	}
	
}
