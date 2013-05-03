package test.entrecine.model;

import static org.junit.Assert.assertEquals;

import models.Room;

import org.junit.Test;


public class RoomTest
{
	private Room room;
	
	private static final long ID=1L;
	private static final int ROWS=25;
	private static final int COLUMNS=30;
	
	/**
	 * Method to test setters of com.entrecine4.model.Room.java
	 */
	@Test
	public void testWithoutParameters()
	{
		room=new Room();
		room.setId(ID);
		room.setRows(ROWS);
		room.setColumns(COLUMNS);
		
		testAttributes(room);
	}
	
	/**
	 * Method to test getters and constructor with parameters of com.entrecine4.model.Room.java
	 */
	@Test
	public void testWithParameters()
	{
		room=new Room(ID, ROWS, COLUMNS);
		
		testAttributes(room);
	}

	/**
	 * Method for test the attributes
	 * @param The room to test
	 */
	private void testAttributes(Room room)
	{
		assertEquals(ID, room.getId());
		assertEquals(ROWS,room.getRows());
		assertEquals(COLUMNS, room.getColumns());
	}

}