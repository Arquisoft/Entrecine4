package test.entrecine.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import models.Room;

import org.junit.Test;

import com.entrecine4.business.RoomService;
import com.entrecine4.infraestructure.Factories;

public class RoomServiceTest 
{
	private RoomService service = Factories.services.createRoomService();
	
	/**
	 * Method that tests the recovering of all the rooms stored in the database
	 */
	@Test
	public void testGetAllRooms() 
	{
		List<Room> rooms = service.getRooms();
		
		assertEquals(1, rooms.get(0).getId());
		assertEquals(2, rooms.get(1).getId());
	}
	
	/**
	 * Method that tests the recovering of a room using its identification number
	 */
	@Test
	public void testFindByID()
	{
		Room room = service.findById(1L);
		
		assertEquals(10, room.getRows());
		assertEquals(20, room.getColumns());
	}
	
	/**
	 * Method that tests the saving of a room into the database, checks if the saving
	 * was correct, and finally deletes it from the database
	 */
	@Test
	public void testSaveDeleteRoom()
	{
		Room room = new Room(0,50,20);
		service.saveRoom(room);
		
		List<Room> rooms = service.getRooms();
		Long id = rooms.get(rooms.size()-1).getId();
		
		Room savedRoom = service.findById(id);
		
		assertEquals(room.getRows(), savedRoom.getRows());
		assertEquals(room.getColumns(), savedRoom.getColumns());
		
		service.deleteRoom(savedRoom);
		
		Room deletedRoom = service.findById(id);
		assertEquals(null, deletedRoom);
	}
	
	/**
	 * Method that tests the updating of the room's data, checks if the updating was
	 * correct, and finally updates it back to the initial data
	 */
	@Test
	public void testUpdateRoom()
	{
		Room room = service.findById(1L);
		
		assertEquals(10, room.getRows());
		assertEquals(20, room.getColumns());
		
		room.setRows(100);
		room.setColumns(10);
		
		service.updateRoom(room);
		Room updatedRoom = service.findById(1L);
		
		assertEquals(room.getRows(), updatedRoom.getRows());
		assertEquals(room.getColumns(), updatedRoom.getColumns());
		
		room.setRows(10);
		room.setColumns(20);
		service.updateRoom(room);
	}
}
