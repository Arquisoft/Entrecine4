package com.entrecine4.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.Session;


public interface SessionDAO
{
	/**
	 * Method to set the connection that the DAO will use
	 * 
	 * @param connection
	 */
	public void setConnection(Connection connection);
	
	
	/**
	 * Method to get a session using the session's identification number
	 * 
	 * @param sessionId The session's identification number
	 * @return The required session
	 * @throws SQLException
	 */
	public Session get(long sessionId) throws SQLException;
	
	/**
	 * Method to get all the sessions from the database
	 * 
	 * @return A list containing all the sessions that are stored in the database
	 * @throws SQLException 
	 */
	public List<Session> getAll() throws SQLException;
	
	/**
	 * Method to save a session in the database
	 * 
	 * @param session The instance of Session to be saved
	 * @throws SQLException 
	 */
	public void save(Session session) throws SQLException;
	
	/**
	 * Method to update the data of a session
	 * 
	 * @param session The instance of Session to be updated
	 * @throws SQLException 
	 */
	public void update(Session session) throws SQLException;
	
	/**
	 * Method to delete a session from the database
	 * 
	 * @param session The instance of Session to be deleted
	 * @throws SQLException 
	 */
	public void delete(Session session) throws SQLException;
}

