package com.floow.dm;

public class WordFrequency extends AbstractJobResult {   
	
	private String word; 
	
	private Long occurrences; 
	
	private String filter; 
	
	private int numLetters;
	
	
	public WordFrequency(String jobid, String word, Long occurrences, String filter, int numLetters) {
		super(jobid);
	}
	
	
	
	public WordFrequency(String searchId, String jobid, String word, Long occurrences, String filter, int numLetters, long jobtime) {
		super(searchId, jobid, jobtime);
	}



	public String getWord() {
		return word;
	}



	public void setWord(String word) {
		this.word = word;
	}



	public Long getOccurrences() {
		return occurrences;
	}



	public void setOccurrences(Long occurrences) {
		this.occurrences = occurrences;
	}



	public String getFilter() {
		return filter;
	}



	public void setFilter(String filter) {
		this.filter = filter;
	}



	public int getNumLetters() {
		return numLetters;
	}



	public void setNumLetters(int numLetters) {
		this.numLetters = numLetters;
	}


	
}
