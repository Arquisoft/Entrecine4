package test.entrecine.persistence;

import static org.junit.Assert.assertEquals;
import impl.entrecine4.persistence.IncidenceJdbcDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import models.Incidence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.persistence.IncidenceDAO;

public class IncidenceDaoTest
{
	private static IncidenceDAO dao=new IncidenceJdbcDAO();
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

	/**
	 * Method to test the insertion of the same incidence twice. It must fail
	 * 
	 * @throws SQLException
	 */
	public void testInsertTwo() throws SQLException {
		Incidence incidence = new Incidence(1L,1L,Date.valueOf("2013-04-20"),1L,"Just an incidence");
		dao.save(incidence);
		dao.save(incidence);
	}

	/**
	 * Method to test the insertion and deletion of an incidence
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testSaveAndDelete() throws SQLException {
		Incidence incidence = new Incidence(1L,1L,Date.valueOf("2013-04-20"),1L,"Just an incidence");
		dao.save(incidence);
		
		List<Incidence> temp=dao.getAll();
		
		Incidence recoveredIncidence = dao.get(temp.get(temp.size()-1).getId());
		assertEquals(incidence.getRoomId(), recoveredIncidence.getRoomId());
		assertEquals(incidence.getDay(), recoveredIncidence.getDay());
		assertEquals(incidence.getSessionId(), recoveredIncidence.getSessionId());
		assertEquals(incidence.getDescription(), recoveredIncidence.getDescription());
		
		dao.delete(incidence);
		assertEquals(null, dao.get(1));
	}

	/**
	 * Method to test the recovering of an incidence that doesn't exist in the database
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetBadId() throws SQLException {
		Incidence incidence = dao.get(-1);
		assertEquals(null, incidence);
	}

	/**
	 * Method to test the update operation of an incidence
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException {
		Incidence incidence = new Incidence(1L,1L,Date.valueOf("2013-04-20"),1L,"Just an incidence");
		dao.save(incidence);

		List<Incidence> temp=dao.getAll();
		incidence.setDescription("Just an incidence again");
		incidence.setId(temp.get(temp.size()-1).getId());
		dao.update(incidence);
		
		Incidence recoveredIncidence = dao.get(temp.get(temp.size()-1).getId());
		assertEquals("Just an incidence again",recoveredIncidence.getDescription());
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
