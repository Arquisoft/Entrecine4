package com.entrecine4.infraestructure;

import com.entrecine4.business.ServicesFactory;
import com.entrecine4.persistence.PersistenceFactory;
import impl.entrecine4.business.SimpleServicesFactory;
import impl.entrecine4.persistence.SimplePersistenceFactory;

public class Factories
{
	/**
	 * Instance of services factory
	 */
	public static ServicesFactory services=new SimpleServicesFactory();
	
	/**
	 * Instance of persistence factory
	 */
	public static PersistenceFactory persistence= new SimplePersistenceFactory();
}
