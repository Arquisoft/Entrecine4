package com.entrecine4.business;

import java.util.Date;
import java.util.List;

import models.Session;

public interface SessionService 
{
	/**
	 * Return all sessions
	 * 
	 * @return A list with the sessions
	 */
	public List<Session> getSessions();
	
	/**
	 * Find a session using the session's identification number
	 * @param id The session's identification number
	 * @return The required session
	 */
	public Session findById(long id);
	
	/**
	 * Find all the session planned for a movie
	 * 
	 * @param movieTitle The movie's title
	 * @return A list with all the sessions for that movie
	 */
	public List<Session> findByMovie(String movieTitle);
	
	/**
	 * Find all sessions of a day
	 * 
	 * @param day The day
	 * @return A list with the sessions for that day
	 */
	public List<Session> findByDay(Date day);
	
	/**
	 * Find sessions using the day and session's time
	 * 
	 * @param day The day
	 * @param time The session's time (12, 17, 20, 22)
	 * @return A list with the sessions for that day and session's time
	 */
	public List<Session> findByDayAndTime(Date day, double time);
	
	/**
	 * Save a session in the system
	 * 
	 * @param session The session to save
	 */
	public void saveSession(Session session);
	
	/**
	 * Update the data of a session in the system
	 * 
	 * @param session The session to update
	 */
	public void updateSession(Session session);

	/**
	 * Delete a session from the database
	 * 
	 * @param session The session to delete
	 */
	public void deleteSession(Session session);
}