package com.entrecine4.business;

import java.util.List;

import com.entrecine4.model.Room;

public interface RoomService {
	
	/**
	 * Retrieves all the rooms
	 * @return the rooms
	 */
	public List<Room> getRooms();
	
	/**
	 * Retrieve one room
	 * @param id
	 * @return the room
	 */
	public Room findById(Long id);

	/**
	 * Save a room
	 * @param room
	 */
	public void saveRoom(Room room);
	
	/**
	 * Update a room
	 * @param room
	 */
	public void updateRoom(Room room);
	
	/**
	 * Delete a room
	 * @param room
	 */
	public void deleteRoom(Room room);
}
