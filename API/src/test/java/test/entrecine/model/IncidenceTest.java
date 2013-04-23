package test.entrecine.model;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

import com.entrecine4.model.Incidence;

public class IncidenceTest 
{
	private Incidence incidence;
	
	private static final long ID=1L;
	private static final long ROOM_ID=1L;
	private static final Date DAY=Date.valueOf("20/01/2013");
	private static final long SESSION_ID=1L;
	private static final String DESCRIPTION="The lights don't work";
	
	/**
	 * Method to test setters of com.entrecine4.model.Incidence.java
	 */
	@Test
	public void testWithoutParameters()
	{
		incidence=new Incidence();
		incidence.setId(ID);
		incidence.setRoomId(ROOM_ID);
		incidence.setDay(DAY);
		incidence.setSessionId(SESSION_ID);
		incidence.setDescription(DESCRIPTION);
		
		testAttributes(incidence);
	}
	
	/**
	 * Method to test getters and constructor with parameters of 
	 * com.entrecine4.model.Incidence.java
	 */
	@Test
	public void testWithParameters()
	{
		incidence=new Incidence(ID, ROOM_ID, DAY, SESSION_ID, DESCRIPTION);
		
		testAttributes(incidence);
	}

	/**
	 * Method for test the attributes
	 * @param The incidence to test
	 */
	private void testAttributes(Incidence incidence)
	{
		assertEquals(ID, incidence.getId());
		assertEquals(ROOM_ID, incidence.getRoomId());
		assertEquals(DAY, incidence.getDay());
		assertEquals(SESSION_ID, incidence.getSessionId());
		assertEquals(DESCRIPTION, incidence.getDescription());
	}
}