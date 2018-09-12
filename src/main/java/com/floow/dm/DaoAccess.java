package com.floow.dm;

/**
 * Class to define the storage connection data  
 */
public class DaoAccess {

	private int port;
	private String hostname;

	public DaoAccess(int port, String hostname) {
		this.port = port;
		this.hostname = hostname;
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

}
