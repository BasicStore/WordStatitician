package com.floow.dm;


public class WordLength extends AbstractJobResult {

	private String word; 
	
	private String filter; 
	
	private int wordLength;
	
	
	public WordLength(String jobid, String word, int wordLength, String filter) {
		super(jobid);
		this.word = word;
		this.wordLength = wordLength;
		this.filter = filter;
	}
	
	
	public WordLength(String searchId, String jobid, String word, int wordLength, String filter, long jobtime) {
		super(searchId, jobid, jobtime);
		this.word = word;
		this.wordLength = wordLength;
		this.filter = filter;
	}
	
	
}