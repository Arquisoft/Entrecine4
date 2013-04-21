package com.entrecine4.persistence;

<<<<<<< HEAD
public interface SessionDAO {

}
=======
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.entrecine4.model.Room;
import com.entrecine4.model.Session;

//TODO:No JUnit till the questions are solved
public interface SessionDAO
{
	/**
	 * Method to get a session from the database using the movie's title,and a day,session's hour
	 * and room
	 * 
	 * @param movieTitle Movie's title
	 * @param day Session's day
	 * @param time Session's hour (12:00/17:00/20:00/22:00)
	 * @param room An instance of Room
	 * @return
	 * @throws SQLException 
	 */
	public Session get(String movieTitle, Date day, double time, Room room) throws SQLException;
	
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
>>>>>>> branch 'API' of https://github.com/Arquisoft/Entrecine4.git
