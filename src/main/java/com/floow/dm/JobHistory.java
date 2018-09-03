package com.floow.dm;

public class JobHistory {

	private String uniqueID;
	private String failureReason;
	private SearchJobStatus status;
	
	
	public JobHistory(String uniqueID) {
		 this.uniqueID = uniqueID;
	}
	
	
	public JobHistory(String uniqueID, String failureReason, SearchJobStatus status) {
		 this.uniqueID = uniqueID;
		 this.failureReason = failureReason;
		 this.status = status;
	}


	public String getUniqueID() {
		return uniqueID;
	}


	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
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
