package com.floow.services;
import java.util.Map;
import org.apache.log4j.Logger;
import com.floow.dao.*;
import com.floow.dm.DaoAccess;


/**
 * Class to collate the result from individual statistical word search jobs
 * as part of the same search
 */
public class WordStatJobsCollatorService extends AbstractService {
	
	private Logger log = Logger.getLogger(WordStatJobsCollatorService.class.getName());
	
	// setup dao access  
	private WordsStatJobsDao wordsStatJobsDao;
		
	
	public WordStatJobsCollatorService(DaoAccess daoAccess, String fileName) {
		super(fileName);
		wordsStatJobsDao = new WordsStatJobsDao(daoAccess);
	}	
	
	
	
	/**
	 * Finds all records submitted by different job ids for the given search id.
	 * Returns a map of unique words for each record plus the cumulative occurrences
	 * of the word in each of the records.
	 * @param searchId - the particular search being carried out by a number of jobs
	 * @param filter - sought word should contain specified filter. If filter is null then no filter is sought.
	 * @param numLetters - sought word should contain specified number of letters. If number of letters is null then ignore this condition. 
	 * @return Map<String, Long> - the number of occurrences against the word itself
	 * @param max - boolean flag to indicate whether to return records of maximum or minimum occurrences
	 */
	public Map<String, Long> findWordsToNumberOfOccurrences(String searchId, String filter, Integer numLetters, boolean max) {
		
		// call List<WordFrequency> getWordFrequencyData(String searchId, String filter, Integer numLetters)
		
		// MONGO COLLECTION [word_frequency]: searchId v jobid v word v occurrences v filter v num_letters v jobtime
		
		return null;
	}
		
	
	
	
	/**
	 * Finds all records submitted by different job ids for the given search id.
	 * Returns a map of the cumulative length of each word against the word itself
	 * @param searchId - the particular search being carried out by a number of jobs
     * @param filter - sought word should contain specified filter. If filter is null then no filter is sought.
	 * @return Map<String, String> - the word length mapped against the words found during all jobs of this search
	 * @param max - boolean flag to indicate whether to return records of maximum or minimum word length
	 */
	public Map<Long, String> findNumberOfLettersForWords(String searchId, String filter, boolean max) {
		
		// MONGO COLLECTION [word_length]: longest_and_shortest_words:            searchId + jobid + word + wordlength + filter v jobtime	
		
		// call:   getWordLengthData(String searchId, String filter)
				
		return null;
	}
	
	
	
	/**
	 * Finds all records submitted by different job ids for the given search id.
	 * Returns the cumulative total of all the words that have been counted,
	 * after applying any filter or restriction on the number of letters. 
	 * @param searchId - the particular search being carried out by a number of jobs
	 * @param filter - sought word should contain specified filter. If filter is null then no filter is sought.
	 * @param numLetters - sought word should contain specified number of letters. If number of letters is null then ignore this condition.
	 * @return Long - the cumulative total number of words found by all the jobs for this particular search
	 */
	public long findTotalWords(String searchId, String filter, Integer numLetters) {
		
		// MONGO COLLECTION [word_totals]: searchId(String) v jobid(String) v num_words(long) v filter(String) v num_letters(int) v jobtime(timestamp)
			
		// call:   getWordTotalData(String searchId, String filter, Integer numLetters)
		
		return 7l;
	}
	
	
}
