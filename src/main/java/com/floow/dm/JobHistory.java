package com.floow.dm;

public class JobHistory {
	
	private String searchId;
	private String jobId;
	private String failureReason;
	private SearchJobStatus status;
	
	
	public JobHistory(String jobId) {
		 this.jobId = jobId;
	}
	
	
	public JobHistory(String searchId, String jobId, String failureReason, SearchJobStatus status) {
		this.searchId = searchId;
	    this.jobId = jobId;
		this.failureReason = failureReason;
	    this.status = status;
	}


	public String getJobId() {
		return jobId;
	}


	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	public String getFailureReason() {
		return failureReason;
	}


	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}


	public SearchJobStatus getStatus() {
		return status;
	}


	public void setStatus(SearchJobStatus status) {
		this.status = status;
	}
	
}
