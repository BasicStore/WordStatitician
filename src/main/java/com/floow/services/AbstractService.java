package com.floow.services;
import com.floow.dm.*;

public abstract class AbstractService {

	protected String fileName;
	
	public AbstractService() {
		
	}
	
	public AbstractService(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
