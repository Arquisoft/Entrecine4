package test.entrecine.persistence;

import static org.junit.Assert.assertEquals;
import impl.entrecine4.persistence.UserJdbcDAO;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entrecine4.model.User;
import com.entrecine4.persistence.UserDAO;

/**
 * Test for User's dao
 * @author Arquisoft - Entrecine4
 *
 */
public class UserDaoTest {
	
	private static UserDAO dao = new UserJdbcDAO();
	private static Connection con = null; 
	
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
	 * Insert two, that is not allowed
	 * @throws SQLException
	 */
	@Test(expected = SQLException.class)
	public void testInsertTwo() throws SQLException {
		User user = new User(0,"pepito", "pepito");
		dao.save(user);
		dao.save(user);
	}
	
	/**
	 * Test of saving and deleting user
	 * @throws SQLException
	 */
	@Test
	public void testSaveAndDelete() throws SQLException {
		User user = new User(0,"pepito", "pepito");
		dao.save(user);
		User recoveredUser = dao.get("pepito");
		assertEquals(user.getUsername(), recoveredUser.getUsername());
		assertEquals(user.getPassword(), recoveredUser.getPassword());
		dao.delete(user);
		assertEquals(dao.get("pepito"), null);
	}
	
	/**
	 * Test with a non existing id
	 * @throws SQLException
	 */
	@Test
	public void testGetBadId() throws SQLException {
		User user = dao.get(-1);
		assertEquals(user, null);
	}
	
	/**
	 * Update test for a user
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException {
		User user = new User(0,"pepito", "pepito");
		dao.save(user);
		user.setPassword("pepiton");
		dao.update(user);
		User recoveredUser = dao.get("pepito");
		assertEquals(recoveredUser.getPassword(), "pepiton");
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

}
