package com.floow.dm;
import java.io.FileInputStream;
import org.apache.commons.lang3.StringUtils;

public class SearchStreamJobRequest extends JobHistory {
	
	private String uniqueID;
	
	private long startByte;
	
	private long endByte;
	
	// the filter. Leave as null if none is to be applied
	private String filter;
	
	// search for words of this number of letters only. Leave as null to ignore this restriction
	private Integer numLetters;
	
	// if the job fails to complete, give some explanation
	private String failureReason;
	
	private FileInputStream fileInputStream;
	
	private DaoAccess daoDetails;

	/*	 
	 TODO:   IMPLEMENT IN JOB!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 
	 this.failureReason = failureReason;
	 SearchJobStatus status
	 */
	
	
	public SearchStreamJobRequest(String searchId, String uniqueID, long startByte, long endByte, String filter, Integer numLetters,
					FileInputStream fileInputStream, DaoAccess daoDetails) {
		super(searchId, uniqueID, StringUtils.EMPTY, SearchJobStatus.PROCESSING);
		this.startByte = startByte;
		this.endByte = endByte;
		this.filter = filter;
		this.numLetters = numLetters;
		this.fileInputStream = fileInputStream;
		this.daoDetails = daoDetails;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public long getStartByte() {
		return startByte;
	}

	public void setStartByte(long startByte) {
		this.startByte = startByte;
	}

	public long getEndByte() {
		return endByte;
	}

	public void setEndByte(long endByte) {
		this.endByte = endByte;
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

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public FileInputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(FileInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public DaoAccess getDaoDetails() {
		return daoDetails;
	}

	public void setDaoDetails(DaoAccess daoDetails) {
		this.daoDetails = daoDetails;
	}
	
}
