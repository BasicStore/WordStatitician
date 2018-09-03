package com.floow.dm;

public enum SearchJobStatus {

	PROCESSING(1, "processing"),
	COMPLETED(2, "completed"),
	FAILED(3, "failed");
	
	private final int id;
	private final String literal; 
	
	SearchJobStatus(int id, String literal) {
		this.id = id;	
		this.literal = literal;
	}

	public int getId() {
		return id;
	}
	
	public static SearchJobStatus getType(int id) {
		for (SearchJobStatus type : SearchJobStatus.values()) {
			if (type.getId() == id) {
				return type;
			}
		}
		
		return null;
	}
	
	
}
