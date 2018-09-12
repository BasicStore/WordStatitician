package com.floow.client;
import java.io.*;


public class ApplicationMain {
	
	/**
	 * Main method for the WordStatitician app
	 * @param args
	 */
	public static void main(String[] args) {
				
		// TODO read in the params from the user
		String hostname = "localhost";
		int port = 5678;		
		String fileName = "enwiki-latest-abstract.xml";
		
		new AppController(hostname, port, fileName);
	}

}
