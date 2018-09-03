package com.floow.dm;

public enum SearchJobStatus {

	REQUESTED(1, "requested"),
	PROCESSING(2, "processing"),
	COMPLETED(3, "completed"),
	FAILED(4, "failed");
	
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
