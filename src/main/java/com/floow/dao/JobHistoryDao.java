package com.floow.dao;
import com.floow.dm.*;
import java.util.List;

/**
 * Class to provide access to job history persistence 
 */
public class JobHistoryDao extends AbstractConnection {

	public JobHistoryDao(DaoAccess daoAccess) {
		getConnection(daoAccess);
	}
	
	
	/**
	 * Persists a job history object
	 * @param jobHist - the job history data
	 */
	public void save(JobHistory jobHist) {
		// MONGO COLLECTION [job_history]:
	}
	
	
	
	/**
	 * Updates the persistence of an existing job history object 
	 * @param jobHist - the job history data
	 */
	public void update(JobHistory jobHist) {
		
		// MONGO COLLECTION [job_history]:
	}
	
	
	/**
	 * Retrieves the job history records for the given search
	 * @param searchId
	 * @return
	 */
	public List<JobHistory> findJobRecords(String searchId) {
				
		// MONGO COLLECTION [job_history]:
		
		// return list of:  JobHistory(String searchId, String jobId, String failureReason, SearchJobStatus status) {
		
		return null;
	}
	
	
	
}

