package com.floow.dm;

/**
 * @author Paul
 *
 */
public enum WordSearchType {
	
	MOST_COMMON_WORD(1),
	MOST_COMMON_WORD_WITH_FILTER(2),
	MOST_COMMON_WORD_OF_N_LETTERS(3),	
	
	LEAST_COMMON_WORD(21),
	LEAST_COMMON_WORD_WITH_FILTER(22),
	LEAST_COMMON_WORD_OF_N_LETTERS(23),
	
	LONGEST_WORD(31),
	LONGEST_WORD_WITH_FILTER(32),
	
	SHORTEST_WORD(41),
	SHORTEST_WORD_WITH_FILTER(42),
	
	TOTAL_WORDS(51),
	TOTAL_WORDS_WITH_FILTER(52),
	TOTAL_WORDS_OF_N_LETTERS(53);
	
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
