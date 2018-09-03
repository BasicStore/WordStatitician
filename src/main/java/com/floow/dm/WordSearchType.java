package com.floow.dm;

/**
 * @author Paul
 *
 */
public enum WordSearchType {
	
	MOST_AND_LEAST_COMMON_WORD(1),
	MOST_AND_LEAST_COMMON_WORD_WITH_FILTER(2),
	MOST_AND_LEAST_COMMON_WORD_OF_N_LETTERS(3),
	LONGEST_AND_SHORTEST_WORD(4),
	LONGEST_AND_SHORTEST_WORD_WITH_FILTER(5),
	TOTAL_WORDS(6),
	TOTAL_WORDS_WITH_FILTER(7),
	TOTAL_WORDS_OF_N_LETTERS(8);
	
	private final int id; 
	
	WordSearchType(int id) {
		this.id = id;		
	}

	public int getId() {
		return id;
	}
	
	public static WordSearchType getType(int id) {
		for (WordSearchType type : WordSearchType.values()) {
			if (type.getId() == id) {
				return type;
			}
		}
		
		return null;
	}
	

}
