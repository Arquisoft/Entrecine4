package test.entrecine.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import models.SessionState;

import org.junit.Test;

import com.entrecine4.business.SessionStateService;
import com.entrecine4.infraestructure.Factories;

public class SessionStateServiceTest 
{
	private SessionStateService service = Factories.services
			.createSessionStateService();
	
	@Test
	public void testGetAllSessionStates() 
	{
		List<SessionState> sessionStates = service.getSessionStates();
		
		assertEquals(1, sessionStates.get(0).getRoomId());
		assertEquals(1, sessionStates.get(1).getRoomId());
		assertEquals(1, sessionStates.get(2).getRoomId());
		assertEquals(1, sessionStates.get(3).getRoomId());
	}
	
	@Test
	public void testFindByID()
	{
		SessionState sessionState = service.findBySession(20).get(0);
		
		assertEquals(1, sessionState.getRoomId());
		assertEquals(3, sessionState.getRow());
		assertEquals(4, sessionState.getColumn());
		assertEquals(Date.valueOf("2013-05-04"), sessionState.getDate());
	}
	
	@Test
	public void testSaveDeleteSessionState()
	{
		SessionState sessionState = new SessionState(0,1,1,Date.valueOf("2010-05-08"),1);
		service.saveSessionState(sessionState);
		
		List<SessionState> sessionStates = service.getSessionStates();
		SessionState savedSessionState = sessionStates.get(0);
		
		assertEquals(sessionState.getRow(), savedSessionState.getRow());
		assertEquals(sessionState.getColumn(), savedSessionState.getColumn());
		
		service.deleteSessionState(savedSessionState);
		
		sessionStates = service.getSessionStates();
		
		assertTrue(sessionStates.get(0).getRoomId()!=0);
	}
	
	@Test
	public void testUpdateSessionState()
	{
		SessionState sessionState = service.findBySession(20).get(0);
		
		assertEquals(1, sessionState.getRoomId());
		assertEquals(3, sessionState.getRow());
		assertEquals(4, sessionState.getColumn());
		assertEquals(Date.valueOf("2013-05-04"), sessionState.getDate());
		
		sessionState.setRow(7);
		sessionState.setColumn(7);
		
		service.updateSessionState(sessionState);
		SessionState updatedSessionState = service.findBySession(20).get(0);
		
		assertEquals(sessionState.getRow(), updatedSessionState.getRow());
		assertEquals(sessionState.getColumn(), updatedSessionState.getColumn());
		
		sessionState.setRow(3);
		sessionState.setColumn(4);
		service.updateSessionState(sessionState);
	}

}
