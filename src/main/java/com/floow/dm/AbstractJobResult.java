package com.floow.dm;


/**
 * Abstract class to record common results from the processing of a statistical word search job 
 */
public abstract class AbstractJobResult {

	private long jobtime;
	
	private String searchId; 
	
	private String jobid;
	
	
	public AbstractJobResult(long jobtime) {
		this.jobtime = jobtime;
	}
	
	
	public AbstractJobResult(String searchId, String jobid, long jobtime) {
		this.jobtime = jobtime;
	}
	
	
	public AbstractJobResult(String jobid) {
		this.jobtime = jobtime;
	}
	
	
}
