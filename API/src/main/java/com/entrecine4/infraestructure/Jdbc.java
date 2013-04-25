package com.entrecine4.infraestructure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * This class provides a simple way to get connections and to close its resources
 * @author Arquisoft - Entrecine4
 *
 */
public class Jdbc {

	private static ComboPooledDataSource cpds;

	/**
	 * Retrieves a connection from the pool of connections
	 * @return a connection
	 */
	public static Connection getConnection() {
		if (cpds == null) {
			try {
				PropertiesReader.setFile("connection.properties");		
				
				cpds = new ComboPooledDataSource();
				cpds.setJdbcUrl(PropertiesReader.get("URL")+"/"+PropertiesReader.get("DBNAME"));
				cpds.setUser(PropertiesReader.get("USER"));
				cpds.setPassword(PropertiesReader.get("PASS"));
				cpds.setInitialPoolSize(Integer.parseInt(PropertiesReader.get("INITIAL_POOL_SIZE")));
				cpds.setMinPoolSize(Integer.parseInt(PropertiesReader.get("MIN_POOL_SIZE")));
				cpds.setMaxPoolSize(Integer.parseInt(PropertiesReader.get("MAX_POOL_SIZE")));		
				
				PropertiesReader.setFile("sql.properties");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}			
		}
		
		try {
			return cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Closes the result set, the statement and the connection
	 * @param result set to close
	 * @param statement to close
	 * @param connection to close
	 */
	public static void close(ResultSet rs, Statement st, Connection c) {
		close(rs);
		close(st);
		close(c);
	}

	/**
	 * Closes the result set and the statement
	 * @param result set to close
	 * @param statement to close
	 */
	public static void close(ResultSet rs, Statement st) {
		close(rs);
		close(st);
	}

	/**
	 * Closes the result set
	 * @param result set to close
	 */
	protected static void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
	}

	/**
	 * Closes the statement
	 * @param statement to close
	 */
	public static void close(Statement st) {
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
			}
	}

	/**
	 * Closes the connection
	 * @param connection to close 
	 */
	public static void close(Connection c) {
		if (c != null)
			try {
				c.close();
			} catch (SQLException e) {
			}
	}
}