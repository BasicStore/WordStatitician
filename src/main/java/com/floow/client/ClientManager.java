package com.floow.client;
import com.floow.services.WordStatSearchService;


public class ClientManager {
	
	private WordStatSearchService service;
	
	public void initWordStatSearchService(WordStatSearchService service) {
		this.service = service;
		
		
		
		
		presentMainMenu();
	}
	
	
	private void presentMainMenu() {
		System.out.println("Main menu goes here.....");
		
	}
	

}
