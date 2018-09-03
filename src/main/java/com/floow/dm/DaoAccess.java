package com.floow.dm;

public class DaoAccess {

	private int port;
	private String hostname;
	private String fileName;
	
	public DaoAccess(int port, String hostname, String fileName) {
		this.port = port;
		this.hostname = hostname;
		this.fileName = fileName;
	}

	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
