package com.entrecine4.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
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
	 * Method to get all the sessions for a movie from the database
	 * 
	 * @param movieTitle The movie's title
	 * @return A list with all the sessions for that movie
	 * @throws SQLException
	 */
	public List<Session> getByMovie(String movieTitle) throws SQLException;
	
	/**
	 * Method to get all the sessions for the supplied day
	 * 
	 * @param day The day
	 * @return A list with all the sessions for that day
	 * @throws SQLException
	 */
	public List<Session> getByDay(Date day) throws SQLException;
	
	/**
	 * Method to get all the sessions for a specific day and session's time
	 * 
	 * @param day The day
	 * @param time The session's time (12, 17, 20, 22)
	 * @return A list with all the sessions for that day and session's time
	 * @throws SQLException
	 */
	public List<Session> getByDayAndTime(Date day, double time) throws SQLException;
	
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

