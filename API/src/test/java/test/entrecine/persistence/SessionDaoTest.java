package test.entrecine.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import impl.entrecine4.persistence.SessionJdbcDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.model.Session;
import com.entrecine4.persistence.SessionDAO;

public class SessionDaoTest
{
	private static SessionDAO dao=new SessionJdbcDAO();
	private static Connection con=Jdbc.getConnection();

	/**
	 * Method before all test
	 * 
	 * @throws SQLException
	 */
	@BeforeClass
	public static void setUp() throws SQLException {
		dao.setConnection(con);
		con.setAutoCommit(false);
	}
	
//	/**
//	 * Method to test the insertion of the same session twice. It must fail
//	 * 
//	 * @throws SQLException
//	 */
//	@Test(expected = SQLException.class)
//	public void testInsertTwo() throws SQLException {
//		Session session = new Session(1L,"Movie",Date.valueOf("20/04/2013"),12,1L);
//		dao.save(session);
//		dao.save(session);
//	}

	/**
	 * Method to test the insertion and deletion of a session
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testSaveAndDelete() throws SQLException {
		Session session = new Session(1L,"Movie",Date.valueOf("2013-04-20"),12,1L);
		dao.save(session);
		
		List<Session> temp=dao.getAll();
		
		Session recoveredSession = dao.get(temp.get(temp.size()-1).getId());
		assertEquals(session.getMovieTitle(), recoveredSession.getMovieTitle());
		assertEquals(session.getDay(), recoveredSession.getDay());
		assertTrue(session.getTime()==recoveredSession.getTime());
		assertEquals(session.getRoomId(), recoveredSession.getRoomId());
		
		dao.delete(session);
		assertEquals(dao.get(1), null);
	}

	/**
	 * Method to test the recovering of a session that doesn't exist in the database
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetBadId() throws SQLException {
		Session session = dao.get(-1);
		assertEquals(session, null);
	}

	/**
	 * Method to test the update operation of a session
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException {
		Session session = new Session(1L,"Movie",Date.valueOf("2013-04-20"),12,1L);
		dao.save(session);
		session.setMovieTitle("Movie 2");
		dao.update(session);
		
		List<Session> temp=dao.getAll();
		
		Session recoveredSession = dao.get(temp.get(temp.size()-1).getId());
		assertEquals("Movie 2",recoveredSession.getMovieTitle());
	}

	/**
	 * Method after all tests
	 * 
	 * @throws SQLException
	 */
	@AfterClass
	public static void setDown() throws SQLException {
		con.rollback();
		con.close();
	}
}