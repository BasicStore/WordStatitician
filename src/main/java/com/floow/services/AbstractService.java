package com.floow.services;
import com.floow.dm.*;

public abstract class AbstractService {

	private DaoAccess dao;
	
	public AbstractService() {
		
	}
	
	public AbstractService(DaoAccess dao) {
		this.dao = dao;
	}
	
}
