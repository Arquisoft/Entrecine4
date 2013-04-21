package com.entrecine4.infraestructure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	/*TODO:Datasource

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}*/

	public static void close(ResultSet rs, Statement st, Connection c)
	{
		close(rs);
		close(st);
		close(c);
	}

	public static void close(ResultSet rs, Statement st)
	{
		close(rs);
		close(st);
	}

	protected static void close(ResultSet rs)
	{
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {}
	}

	public static void close(Statement st)
	{
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {}
	}

	public static void close(Connection c)
	{
		if (c != null)
			try {
				c.close();
			} catch (SQLException e){}
	}
}