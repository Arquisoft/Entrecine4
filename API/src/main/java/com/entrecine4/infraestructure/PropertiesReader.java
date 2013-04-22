package com.entrecine4.infraestructure;

import java.io.IOException;
import java.util.Properties;

@SuppressWarnings("unused")
public class PropertiesReader {

	private static final String SQL_PROPERTIES = "sql.properties";
	private static final String SERVER_CONNECTION_PROPERTIES="serverConnection.properties";
	private static String ACTUAL_FILE=SQL_PROPERTIES;
	
	private static PropertiesReader instance;
	private Properties properties;

	private PropertiesReader() {
		properties = new Properties();
		try {
			properties.load(PropertiesReader.class.getClassLoader().getResourceAsStream(ACTUAL_FILE));
		} catch (IOException e) {
			throw new RuntimeException("Propeties file can not be loaded", e);
		}
	}
	
	public static void setFile(String file)
	{
		ACTUAL_FILE=file;
		instance=new PropertiesReader();
	}
	
	public static String get(String key) {
		return getInstance().getProperty( key );
	}

	private String getProperty(String key) {
		String value = properties.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Property not found in config file");
		}
		return value;
	}

	private static PropertiesReader getInstance() {
		if (instance == null) {
			instance = new PropertiesReader();
		}
		return instance;
	}

}
