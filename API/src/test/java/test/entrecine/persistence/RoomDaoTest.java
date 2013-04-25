package test.entrecine.persistence;

import static org.junit.Assert.assertEquals;
import impl.entrecine4.persistence.RoomJdbcDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.model.Room;
import com.entrecine4.persistence.RoomDAO;

public class RoomDaoTest 
{
	private static RoomDAO dao=new RoomJdbcDAO();
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
//	 * Method to test the insertion of the same room twice. It must fail
//	 * 
//	 * @throws SQLException
//	 */
//	@Test(expected = SQLException.class)
//	public void testInsertTwo() throws SQLException {
//		Room room = new Room(1L,5,7);
//		dao.save(room);
//		dao.save(room);
//	}

	/**
	 * Method to test the insertion and deletion of a room
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testSaveAndDelete() throws SQLException {
		Room room = new Room(1L,5,7);
		dao.save(room);
		
		List<Room> temp=dao.getAll();
		
		Room recoveredRoom = dao.get(temp.get(temp.size()-1).getId());
		assertEquals(room.getRows(), recoveredRoom.getRows());
		assertEquals(room.getColumns(), recoveredRoom.getColumns());
		
		dao.delete(room);
		assertEquals(dao.get(1), null);
	}

	/**
	 * Method to test the recovering of a room that doesn't exist in the database
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetBadId() throws SQLException {
		Room room = dao.get(-1);
		assertEquals(room, null);
	}

	/**
	 * Method to test the update operation of a room
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException {
		Room room = new Room(1L,5,7);
		dao.save(room);
		room.setRows(11);
		
		List<Room> temp=dao.getAll();
		room.setId(temp.get(temp.size()-1).getId());
		dao.update(room);
		
		Room recoveredRoom = dao.get(temp.get(temp.size()-1).getId());
		assertEquals(11,recoveredRoom.getRows());
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
