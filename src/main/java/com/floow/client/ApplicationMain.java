package com.floow.client;
import java.io.*;


public class ApplicationMain {
	
	public static void main(String[] args) {
		
		// TODO read in the params from the user
		String hostname = "localhost";
		int port = 5678;		
		String fileName = "..\\..\\FLOOW_DUMP\\enwiki-latest-abstract.xml";
			
		File test = new File("testMe");
		try {
		test.createNewFile();
		} catch(IOException e) {
			
		}
		
		
		
		new AppController(hostname, port, fileName);
	}

}
