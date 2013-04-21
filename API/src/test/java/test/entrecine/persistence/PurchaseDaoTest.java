package test.entrecine.persistence;

import static org.junit.Assert.*;
import impl.entrecine4.persistence.PurchaseJdbcDAO;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entrecine4.model.Purchase;
import com.entrecine4.persistence.PurchaseDAO;

public class PurchaseDaoTest {

	private static PurchaseDAO dao = new PurchaseJdbcDAO();
	private static Connection con = null; // we need the connection here

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
	 * Insert two purchases with the same ticket_id_code. Expected to fail
	 * 
	 * @throws SQLException
	 */
	@Test(expected = SQLException.class)
	public void testInsertTwo() throws SQLException {
		Purchase purchase = new Purchase(1, 1, 1, "1234asdf", 0, 0);
		dao.save(purchase);
		dao.save(purchase);
	}

	/**
	 * Test of saving and deleting a purchase
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testSaveAndDelete() throws SQLException {
		Purchase purchase = new Purchase(1, 1, 1, "1234asdf", 0, 0);
		dao.save(purchase);
		Purchase recoveredPurchase = dao.get(1);
		assertEquals(purchase.getMovie_id(), recoveredPurchase.getMovie_id());
		assertEquals(purchase.getUser_id(), recoveredPurchase.getUser_id());
		assertEquals(purchase.getTicket_id_code(), recoveredPurchase.getTicket_id_code());
		dao.delete(purchase);
		assertEquals(dao.get(1), null);
	}

	/**
	 * Test with a non existing id
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetBadId() throws SQLException {
		Purchase p = dao.get(-1);
		assertEquals(p, null);
	}

	/**
	 * Update test for a user
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException {
		Purchase purchase = new Purchase(1, 1, 1, "1234asdf", 0, 0);
		dao.save(purchase);
		purchase.setPaid(1);
		Purchase purchaseRecovered = dao.get(2);
		assertEquals(purchaseRecovered.getPaid(), 1);
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
