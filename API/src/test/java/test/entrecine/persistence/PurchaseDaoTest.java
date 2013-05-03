package test.entrecine.persistence;

import static org.junit.Assert.*;
import impl.entrecine4.persistence.PurchaseJdbcDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.Purchase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.persistence.PurchaseDAO;

public class PurchaseDaoTest {

	private static PurchaseDAO dao = new PurchaseJdbcDAO();
	private static Connection con = Jdbc.getConnection(); // we need the connection here

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
	 * Insert two purchases. Since the ID code is generated automatically
	 * by the Data Base, it's not expected to fail
	 * 
	 * @throws SQLException
	 */
	@Test
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
		List<Purchase> recoveredPurchases = dao.getAll();
		Purchase recoveredPurchase = recoveredPurchases.get(recoveredPurchases.size() - 1);
		assertEquals(purchase.getUser_id(), recoveredPurchase.getUser_id());
		assertEquals(purchase.getTicket_id_code(), recoveredPurchase.getTicket_id_code());
		purchase.setId(recoveredPurchase.getId());
		dao.delete(purchase);
		assertEquals(null, dao.get(recoveredPurchase.getId()));
	}

	/**
	 * Test with a non existing id
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetBadId() throws SQLException {
		Purchase p = dao.get(-1);
		assertEquals(null, p);
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
		List<Purchase> purchasesRecovered = dao.getAll();
		Purchase purchaseRecovered = purchasesRecovered.get(purchasesRecovered.size() - 1);
		purchase.setId(purchaseRecovered.getId());
		purchase.setPaid(1);
		dao.update(purchase);
		purchasesRecovered = dao.getAll();
		purchaseRecovered = purchasesRecovered.get(purchasesRecovered.size() - 1);
		assertEquals(1, purchaseRecovered.getPaid());
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
