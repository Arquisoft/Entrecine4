package test.entrecine.persistence;

import static org.junit.Assert.assertEquals;
import impl.entrecine4.persistence.SessionStateJdbcDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import models.SessionState;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.persistence.SessionStateDAO;

public class SessionStateDaoTest {

	private static SessionStateDAO dao = new SessionStateJdbcDAO();
	private static Connection con = Jdbc.getConnection();
	
	/**
	 * Method before all test
	 * @throws SQLException
	 */
	@BeforeClass
	public static void setUp() throws SQLException {
		dao.setConnection(con);
		con.setAutoCommit(false);
	}

	/**
	 * Insert two equal entities. That is not allowed
	 * @throws SQLException
	 */
	@Test(expected = SQLException.class)
	public void testInsertTwo() throws SQLException {
		SessionState sessionState = new SessionState(1, 3, 5, new Date(), 3);
		dao.save(sessionState);
		dao.save(sessionState);
	}
	
	/**
	 * Test of saving and deleting session's state
	 * @throws SQLException
	 */
	@Test
	public void testSaveAndDelete() throws SQLException {
		SessionState sessionState = new SessionState(1, 3, 5, new Date(), 3);
		dao.save(sessionState);
		SessionState recoveredSessionState = dao.get(sessionState);
		assertEquals(sessionState.getRoomId(), recoveredSessionState.getRoomId());
		assertEquals(sessionState.getRow(), recoveredSessionState.getRow());
		assertEquals(sessionState.getColumn(), recoveredSessionState.getColumn());
		assertEquals(sessionState.getSession(), recoveredSessionState.getSession());
		dao.delete(sessionState);
		assertEquals(null, dao.get(sessionState));
	}
	
	/**
	 * Update test for a user
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException {
		SessionState sessionState = new SessionState(1, 3, 5, new Date(), 3);
		dao.save(sessionState);
		sessionState.setRow(5);
		sessionState.setColumn(10);
		dao.update(sessionState);
		SessionState recoveredSessionState = dao.get(sessionState);
		assertEquals(5, recoveredSessionState.getRow());
		assertEquals(10, recoveredSessionState.getColumn());
	}
	
	/**
	 * Method after all tests
	 * @throws SQLException
	 */
	@AfterClass
	public static void setDown() throws SQLException {
		con.rollback();
		con.close();
	}
	
	/**
	 * Method after every test, to clean data
	 * @throws SQLException
	 */
	@After
	public void rollback() throws SQLException {
		con.rollback();
	}

}
