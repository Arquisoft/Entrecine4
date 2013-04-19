package com.entrecine4.persistence;

import java.sql.SQLException;
import java.util.List;

import com.entrecine4.model.Room;

//TODO:No javadoc yet
public interface RoomDAO 
{
	public Room get(long roomId) throws SQLException;
	public List<Room> getAll() throws SQLException;
	public void save(Room room) throws SQLException;
	public void update(Room room) throws SQLException;
	public void delete(Room room) throws SQLException;
}
