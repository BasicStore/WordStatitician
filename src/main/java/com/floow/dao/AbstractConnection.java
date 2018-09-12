package com.floow.dao;

import com.floow.dm.DaoAccess;

/**
 * The generic class for access to storage
 */
public abstract class AbstractConnection {
	
	private DaoAccess daoAccess;
	
	protected void getConnection(DaoAccess daoAccess) {
		// TODO apply singleton here.........
		this.daoAccess = daoAccess;
	}
	
}
