package com.entrecine4.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import models.SessionState;


/**
 * Session's state dao interface
 * @author Arquisoft - Entrecine4
 *
 */
public interface SessionStateDAO {

	/**
	 * Set the conecction to use
	 * @param connection
	 */
	void setConnection(Connection con);
	
	/**
	 * Returns the session state requested the DTO, this is
	 * interesting to know if it is free or not
	 * @param ss the session's state
	 * @return the SessionState if exits, otherwise null
	 * @throws SQLException
	 */
	SessionState get(SessionState ss) throws SQLException;
	
	/**
	 * Returns a list of session's state
	 * @param roomId
	 * @param date
	 * @param session
	 * @return a list of session's state
	 * @throws SQLException
	 */
	List<SessionState> get(long roomId, Date date, long session) throws SQLException;
	
	/**
	 * Return a list with all the session's states for the supplied session
	 * 
	 * @param sessionId The session's identification number
	 * @return A list with all the session's states for the supplied session
	 * @throws SQLException
	 */
	List<SessionState> getBySession(long sessionId) throws SQLException;
	
	/**
	 * Returns a list with all session's states
	 * 
	 * @return A list with the session's states
	 * @throws SQLException
	 */
	List<SessionState> getAll() throws SQLException;
	
	/**
	 * Save the given Session's state
	 * @param ss the session's state
	 * @throws SQLException
	 */
	void save(SessionState ss) throws SQLException;
	
	/**
	 * Update the existing session's state according to room's id, date and session
	 * @param ss the session's state
	 * @throws SQLException
	 */
	void update(SessionState ss) throws SQLException;
	
	/**
	 * Delete the existing session's state
	 * @param ss the session's state
	 * @throws SQLException
	 */
	void delete(SessionState ss) throws SQLException;
	
}
