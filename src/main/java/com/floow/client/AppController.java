package com.floow.client;
import com.floow.services.WordStatSearchService;


/**
 * Controller class for the WordStatitician app 
 */
public class AppController {

	public AppController(String hostname, int port, String filePath) {
		WordStatSearchService model = new WordStatSearchService(port, hostname, filePath);
		ClientManager view = new ClientManager();
		view.initWordStatSearchService(model);
	}
		
}
