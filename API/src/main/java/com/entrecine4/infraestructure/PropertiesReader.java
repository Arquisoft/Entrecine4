package com.entrecine4.infraestructure;

import java.io.IOException;
import java.util.Properties;

/**
 * Class to read properties from .properties files <br />
 * Sql statements properties file is the default file
 * @author Arquisoft - Entrecine4
 *
 */
public class PropertiesReader {

	private static final String SQL_PROPERTIES = "sql.properties";
//	private static final String SERVER_CONNECTION_PROPERTIES="serverConnection.properties";
	private static String ACTUAL_FILE=SQL_PROPERTIES;
	
	private static PropertiesReader instance;
	private Properties properties;

	/**
	 * Constructor, its private because of singleton pattern
	 */
	private PropertiesReader() {
		properties = new Properties();
		try {
			properties.load(PropertiesReader.class.getClassLoader().getResourceAsStream(ACTUAL_FILE));
		} catch (IOException e) {
			throw new RuntimeException("Propeties file can not be loaded", e);
		}
	}
	
	/**
	 * Changes the file of the properties
	 * @param file as a string
	 */
	public static void setFile(String file) {
		ACTUAL_FILE = file;
		instance = new PropertiesReader();
	}
	
	/**
	 * Return the value of passed key
	 * @param key of the property
	 * @return value
	 */
	public static String get(String key) {
		return getInstance().getProperty( key );
	}

	/**
	 * Return the property value
	 * @param key
	 * @return value
	 */
	private String getProperty(String key) {
		String value = properties.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Property not found in config file");
		}
		return value;
	}

	/**
	 * Singleton getInstance() method
	 * @return the unique PropertiesReader
	 */
	private static PropertiesReader getInstance() {
		if (instance == null) {
			instance = new PropertiesReader();
		}
		return instance;
	}

}
