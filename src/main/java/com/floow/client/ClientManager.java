package com.floow.client;
import java.io.File;
import java.io.FileInputStream;
import org.apache.log4j.Logger;
import com.floow.dm.AbstractSearchResult;
import com.floow.exceptions.FailedSearchException;
import com.floow.services.WordStatSearchService;
import com.floow.utils.SysProperties;
import java.nio.channels.FileChannel;

public class ClientManager {
	
	private Logger log = Logger.getLogger(ClientManager.class.getName());
	
	private WordStatSearchService service;
	
	public void initWordStatSearchService(WordStatSearchService service) {
		this.service = service;
		
		String propVal = SysProperties.getProperty("max_processing_time_ms");
		log.info("max processing time 77777 = " + propVal);
		
		presentMainMenu();
	}
	
	
	private void presentMainMenu() {
		
		log.info("presenting main menu.........starting the search");
	
		try {
			AbstractSearchResult searchResult = service.getMostAndLeastCommonWords();
			
			log.info("search finished.........");
			
			
		} catch(FailedSearchException e) {
			log.info("crashed performing the search.........");
		}
		
		
		
	}
	
	
	private void testScanningFile() {
		
	}
	
	
	
	
	/*
	 * FileInputStream inputStream = null;
Scanner sc = null;
try {
    inputStream = new FileInputStream(path);
    sc = new Scanner(inputStream, "UTF-8");
    while (sc.hasNextLine()) {
        String line = sc.nextLine();
        // System.out.println(line);
    }
    // note that Scanner suppresses exceptions
    if (sc.ioException() != null) {
        throw sc.ioException();
    }
} finally {
    if (inputStream != null) {
        inputStream.close();
    }
    if (sc != null) {
        sc.close();
    }
}
	 */
	
	
	
	
	

}
