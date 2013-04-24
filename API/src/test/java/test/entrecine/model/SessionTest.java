package test.entrecine.model;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

import com.entrecine4.model.Session;

public class SessionTest
{
	private Session session;
	
	private static final long ID=1L;
	private static final String MOVIE_TITLE="Matrix";
	private static final Date DAY= new Date(System.currentTimeMillis());
	private static final double TIME=12D;
	private static final long ROOM_ID=1L;
	
	/**
	 * Method to test setters of com.entrecine4.model.Session.java
	 */
	@Test
	public void testWithoutParameters()
	{
		session=new Session();
		session.setId(ID);
		session.setMovieTitle(MOVIE_TITLE);
		session.setDay(DAY);
		session.setTime(TIME);
		session.setRoomId(ROOM_ID);
		
		testAttributes(session);
	}
	
	/**
	 * Method to test getters and constructor with parameters of 
	 * com.entrecine4.model.Session.java
	 */
	@Test
	public void testWithParameters()
	{
		session=new Session(ID, MOVIE_TITLE, DAY, TIME, ROOM_ID);
		
		testAttributes(session);
	}

	/**
	 * Method for test the attributes
	 * @param The session to test
	 */
	private void testAttributes(Session session)
	{
		assertEquals(ID, session.getId());
	}
}