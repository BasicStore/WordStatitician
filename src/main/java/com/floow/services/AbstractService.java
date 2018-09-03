package com.floow.services;
import com.floow.dm.*;

public abstract class AbstractService {

	protected DaoAccess dao;
	
	public AbstractService() {
		
	}
	
	public AbstractService(DaoAccess dao) {
		this.dao = dao;
	}

	public DaoAccess getDao() {
		return dao;
	}
	
}
