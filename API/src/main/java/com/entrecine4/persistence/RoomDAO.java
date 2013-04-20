package com.entrecine4.persistence;

import java.sql.SQLException;
import java.util.List;

import com.entrecine4.model.Room;

public interface RoomDAO 
{
	/**
	 * Method to get a room from the database using an id
	 * 
	 * @param roomId
	 * @return The requested room
	 * @throws SQLException
	 */
	public Room get(long roomId) throws SQLException;
	
	/**
	 * Method to get all the rooms from the database
	 * 
	 * @return A list containing all the rooms
	 * @throws SQLException
	 */
	public List<Room> getAll() throws SQLException;
	
	/**
	 * Method to save a room in the database
	 * 
	 * @param room The instance of Room to be saved
	 * @throws SQLException
	 */
	public void save(Room room) throws SQLException;
	
	/**
	 * Method to update the data of a room in the database
	 * 
	 * @param room The instance of Room to be updated
	 * @throws SQLException
	 */
	public void update(Room room) throws SQLException;
	
	/**
	 * Method to delete a room from the database
	 * 
	 * @param room The instance of Room to be deleted
	 * @throws SQLException
	 */
	public void delete(Room room) throws SQLException;
}
