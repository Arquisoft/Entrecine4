package test.entrecine.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import models.Session;

import org.junit.Test;

import com.entrecine4.business.SessionService;
import com.entrecine4.infraestructure.Factories;

public class SessionServiceTest 
{
	private SessionService service = Factories.services.createSessionService();
	
	/**
	 * Method that tests the recovering of all the sessions stored in the database
	 */
	@Test
	public void testGetAllSessions() 
	{
		List<Session> sessions = service.getSessions();
		
		assertEquals(23, sessions.get(0).getId());
		assertEquals(24, sessions.get(1).getId());
		assertEquals(25, sessions.get(2).getId());
		assertEquals(26, sessions.get(3).getId());
	}
	
	/**
	 * Method that tests the recovering of a sessions using a identification number
	 */
	@Test
	public void testFindByID()
	{
		Session session = service.findById(25L);
		
		assertEquals("Ironman 3", session.getMovieTitle());
		assertEquals(Date.valueOf("2013-05-08"), session.getDay());
		assertTrue(12==session.getTime());
		assertEquals(1, session.getRoomId());	
	}
	
	/**
	 * Method that tests the recovering of sessions using different methods, like
	 * finding by a movie's name, a day, etc.
	 */
	@Test
	public void testFinders()
	{
		List<Session> sessions = service.findByMovie("Ironman 3");
		
		
		for(Session s: sessions)
			assertEquals("Ironman 3", s.getMovieTitle());
		
		sessions = service.findByDay(Date.valueOf("2013-05-08"));
		
		assertEquals(4, sessions.size());
		for(Session s: sessions)
		{
			if(s.getId()==24)
				assertEquals("Buscando a Nemo 3D", s.getMovieTitle());
			else
				assertEquals("Ironman 3", s.getMovieTitle());
		}
		
		sessions = service.findByDateTimeAndFilmName(Date.valueOf("2013-05-08")
				,12D, "Ironman 3");
		List<Session> sessions2 = service.findByDayAndTime(Date.valueOf("2013-05-08")
				, 12D);
		
		for(int i=0; i<sessions.size();i++)
			assertEquals(sessions.get(i).getId(), sessions2.get(i).getId());
	}
	
	/**
	 * Method that tests the saving of a session into the database, checks if the 
	 * saving was correct, and finally deletes it from the database
	 */
	@Test
	public void testSaveDeleteSession()
	{
		Session session = new Session(0, "Ironman 3", Date.valueOf("2013-05-07"), 20, 2);
		service.saveSession(session);
		
		List<Session> sessions = service.getSessions();
		Long id = sessions.get(sessions.size()-1).getId();
		
		Session savedSession = service.findById(id);
		
		assertEquals(session.getMovieTitle(), savedSession.getMovieTitle());
		assertEquals(session.getDay(), savedSession.getDay());
		
		service.deleteSession(savedSession);
		
		Session deletedSession = service.findById(id);
		assertEquals(null, deletedSession);
	}
	
	/**
	 * Method that tests the updating of a session's data, checks if the updating
	 * was correct, and finally updates it back to the initial data
	 */
	@Test
	public void testUpdateSession()
	{
		Session session = service.findById(25L);
		
		assertEquals("Ironman 3", session.getMovieTitle());
		assertEquals(Date.valueOf("2013-05-08"), session.getDay());
		assertTrue(12==session.getTime());
		assertEquals(1, session.getRoomId());	
		
		session.setMovieTitle("42");
		session.setRoomId(2);
		
		service.updateSession(session);
		Session updatedSession = service.findById(25L);
		
		assertEquals(session.getMovieTitle(), updatedSession.getMovieTitle());
		assertEquals(session.getDay(), updatedSession.getDay());
		assertTrue(session.getTime()==updatedSession.getTime());
		assertEquals(session.getRoomId(), updatedSession.getRoomId());	
		
		session.setMovieTitle("Ironman 3");
		session.setRoomId(1);
		service.updateSession(session);
	}

}
