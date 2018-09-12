package com.floow.dao;
import java.util.List;
import com.floow.dm.*;


/**
 * Class to provide access to the persistence of statistically relevant information
 * collated by individual jobs on particular word searches.
 */
public class WordsStatJobsDao extends AbstractConnection {
	
	public WordsStatJobsDao(DaoAccess daoAccess) {
		getConnection(daoAccess);
	}
	
	
	/**
	 * Persists the number of occurrences of each statistically interesting word found by a particular job as part of a particular search.
	 * The word may have to contain letters of the given filter, and of the given number of letters if either of these are specified.
	 * @param word - the word of statistical interest found by this particular job of the specified search
	 * @param occurrences - occurrences found of the specified word as part of this job for the specified search
	 * @param searchId - the particular search that all jobs are working to accomplish
	 * @param jobid - the particular job of the given search
	 * @param filter - sought word should contain specified filter. If filter is null then no filter is sought.
	 * @param numLetters - sought word should contain specified number of letters. If number of letters is null then ignore this condition. 
	 * @param max - boolean flag to indicate whether this record summarises maximum or minimum word occurrences
	 */
	public void saveWordToNumberOfOccurrences(String word, long occurrences, String searchId, String jobid, String filter, Integer numLetters, boolean max) {
		
		// create new:  WordFrequency(String jobid, String word, Long occurrences, String filter, Integer numLetters) 
		
		// MONGO COLLECTION [word_frequency]: searchId(String) v jobid(String) v word(String) v occurrences(Long) v filter(String) v num_letters(int) v max v jobtime(timestamp)
		
	}
	
	
	
	/**
	 * Fetches a list of word frequency objects for all jobs in the specified search.
	 * Note that a word is not unique to each job of the search.
	 * @param searchId - the particular search being carried out by a number of jobs
	 * @param filter - sought word should contain specified filter. If filter is null then no filter is sought.
	 * @param numLetters - sought word should contain specified number of letters. If number of letters is null then ignore this condition.
	 * @param max - boolean flag to indicate whether to return records of maximum or minimum occurrences 
	 * @return
	 */
	public List<WordFrequency> getWordFrequencyData(String searchId, String filter, Integer numLetters, boolean max) {
		
		
		// MONGO COLLECTION [word_frequency]: searchId v jobid v word v occurrences v filter v num_letters v max v jobtime
		
		//  RETURN    list of   WordFrequency(String jobid, String word, Long occurrences, String filter, Integer numLetters) {
		
		
		return null;
	}
	
	
	
	
	/**
	 * Persists the number of letters of statistically interesting words found by a particular job as part of a particular search.
	 * @param word - the word of statistical interest found by this particular job of the specified search
	 * @param occurrences - occurrences found of the specified word as part of this job for the specified search
	 * @param searchId - the particular search that all jobs are working to accomplish
	 * @param jobid - the particular job of the given search
	 * @param filter - sought word should contain specified filter. If filter is null then no filter is sought.
	 * @param numLetters - sought word should contain specified number of letters. If number of letters is null then ignore this condition. 
	 * @param max - boolean flag to indicate whether this record summarises maximum or minimum word length
	 */
	public void saveNumberOfLettersToWord(String word, long numLettersInWord, String searchId, String jobid, String filter, boolean max) {
		
		// MONGO COLLECTION [word_length]:  searchId(String) + jobid(String) + word(String) + wordlength(int) + filter(String) v max v jobtime(timestamp)
		
		
		
		
	}
	
	
	
	/**
	 * Fetches a list of word length objects for all jobs in the specified search.
	 * Note that neither the word nor the word length is not unique to each job of the search.
	 * @param searchId - the particular search being carried out by a number of jobs
     * @param filter - sought word should contain specified filter. If filter is null then no filter is sought.
	 * @param max - boolean flag to indicate whether to return records of maximum or minimum word length
	 * @return
	 */
	public List<WordLength> getWordLengthData(String searchId, String filter, boolean max) {
		
		// MONGO COLLECTION [word_length]: searchId + jobid + word + wordlength + filter v max v jobtime
		
		//  RETURN    list of WordLength(String jobid, String word, int wordLength, String filter) 
		
		return null;
	}
	
	
	
	
	/**
	 * Persists the total number of words found for a particular job as part of the given search.
	 * The number of words found is specific to the given filter and/or the number of letters
	 * specified for the word.
	 * @param searchId - the particular search that all jobs are working to accomplish
	 * @param jobid - the particular job of the given search
	 * @param numWords - the number of words counted as part of this job within a particular search
	 * @param filter - sought word should contain specified filter. If filter is null then no filter is sought.
	 * @param numLetters - sought word should contain specified number of letters. If number of letters is null then ignore this condition.
	 */
	public void saveTotalWords(String searchId, String jobid, long numWords, String filter, Integer numLetters) {
		
		// MONGO COLLECTION [word_totals]: searchId v jobid v num_words v filter v num_letters v jobtime
		
		
		
		
	}
	
	
	
	/**
	 * Fetches a list of word total objects for all jobs in the specified search.
	 * @param searchId - the particular search being carried out by a number of jobs
     * @param filter - sought word should contain specified filter. If filter is null then no filter is sought.
     * @param numLetters - sought word should contain specified number of letters. If number of letters is null then ignore this condition. 
	 * @return
	 */
	public List<WordTotal> getWordTotalData(String searchId, String filter, Integer numLetters) {
		//  RETURN list of WordTotal(String jobid, long numWords, String filter, int numLetters)
		

		return null;	
	}
	
	
}
