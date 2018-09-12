package com.floow.dm;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class SearchJobRequest extends JobHistory implements Runnable {
	
	private String jobId;
	
	// the filter. Leave as null if none is to be applied
	private String filter;
	
	// search for words of this number of letters only. Leave as null to ignore this restriction
	private Integer numLetters;
	
	// if the job fails to complete at any stage, give some explanation
	private String failureReason;
	
	private ByteBuffer content;
	
	private String previousWord;
	
	private String finalWord;
	
	private DaoAccess daoDetails;
	
		
	public SearchJobRequest(String searchId, String jobId, String filter, Integer numLetters,
					ByteBuffer content, List<WordSearchType> srchTypes, DaoAccess daoDetails) {
		super(searchId, jobId, StringUtils.EMPTY, SearchJobStatus.PROCESSING);
		this.filter = filter;
		this.numLetters = numLetters;
		this.daoDetails = daoDetails;
		this.content = content;
	}
	
	

	public void run()
	{
		JobHistory jobRecord = new JobHistory(searchId, jobId, null, SearchJobStatus.PROCESSING);
		
		// TODO save this job record to database !!!!!!!!!!!!!!!!!!!!!!!!
		
		String bufStr = new String(content.array(), Charset.forName("UTF-8")); // how to determine line breaks?????
        //System.out.println("beffer = " + bufStr);
		
		// String prevWord = lastWordMap get element (_sequence_number - 1) ==> ie get the word from the last map
		
		// FINE - plonk the Buffer on the JMS queue [putOntoQueue(ByteBuffer buff, String prevWord)]
		//        note that the consumer should convert the buffer to a string, and prefix it with the previous word and a space 
				
		// String lastWord = buff.toString() .....get the last word (unless it ends with a space)
		
		// put lastword onto lastWordMap:    lastWordMap.put(_sequence_number, lastword);
		
		// System.out.println("\n____________________________________________________________________________________________________________\n");
		
		// TODO REMEMBER: consumers should ignore the last word of their buffer unless it ends with a space		
	}
	
	
	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
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

	public void setDaoDetails(DaoAccess daoDetails) {
		this.daoDetails = daoDetails;
	}
	
}
