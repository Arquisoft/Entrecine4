package com.entrecine4.infraestructure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Jdbc {

	private static ComboPooledDataSource cpds;

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
				
				return cpds.getConnection();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}

	public static void close(ResultSet rs, Statement st, Connection c) {
		close(rs);
		close(st);
		close(c);
	}

	public static void close(ResultSet rs, Statement st) {
		close(rs);
		close(st);
	}

	protected static void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
	}

	public static void close(Statement st) {
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
			}
	}

	public static void close(Connection c) {
		if (c != null)
			try {
				c.close();
			} catch (SQLException e) {
			}
	}
}