package com.floow.dm;

public class DaoAccess {

	private int port;
	private String hostname;
	private String filePath;
	
	public DaoAccess(int port, String hostname, String filePath) {
		this.port = port;
		this.hostname = hostname;
		this.filePath = filePath;
	}
	
}
