package com.entrecine4.business;

import java.util.List;

import models.SessionState;

public interface SessionStateService 
{
	/**
	 * Return all the session's states. It means, all the taken places in each room,
	 * for each session, etc.
	 * 
	 * @return A list with all the session's states
	 */
	public List<SessionState> getSessionStates();
	
	/**
	 * Find a session's state using the session's identification number
	 * 
	 * @param sessionId The session's identification number
	 * @return A list with all the session's states for that session
	 */
	public List<SessionState> findBySession(long sessionId);
	
	/**
	 * Check if the seat in that session and room is free or not
	 * 
	 * @param session The session's identification number
	 * @param room The room's identification number
	 * @param row The seat's row
	 * @param column The seat's column
	 * @return True if the seat is free, and false if it isn't
	 */
	public boolean checkFreeSeat(long session, long room, int row, int column);
	
	/**
	 * Save a session's state in the database, so the seat of that session's state object
	 * will be locked and the others customers won't be able to take it
	 * 
	 * @param sessionState The session's state to save
	 */
	public void saveSessionState(SessionState sessionState);
	
	/**
	 * Update a session's state in the database
	 * 
	 * @param sessionState The session's state to update
	 */
	public void updateSessionState(SessionState sessionState);
	
	/**
	 * Delete a session's state from the database
	 * 
	 * @param sessionState The session's state to delete
	 */
	public void deleteSessionState(SessionState sessionState);
}
