package com.entrecine4.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.Purchase;


public interface PurchaseDAO {
	
	/**
	 * Set the connection that will be used
	 * @param con
	 */
	public void setConnection(Connection con);
	
	/**
	 * Returns the purchase searching by its ID
	 * @param ID
	 * @return
	 * @throws SQLException
	 */
	public Purchase get(long ID) throws SQLException;
	
	/**
	 * Returns a list of all the purchases
	 * @return
	 * @throws SQLException
	 */
	public List<Purchase> getAll() throws SQLException;
	
	/**
	 * Saves a new Purchase in the Database
	 * @param purchase
	 * @throws SQLException
	 */
	public void save(Purchase purchase) throws SQLException;
	
	/**
	 * Updates the information of a purchase
	 * @param purchase
	 * @throws SQLException
	 */
	public void update(Purchase purchase) throws SQLException;
	
	/**
	 * Deletes a purchase
	 * @param purchase
	 * @throws SQLException
	 */
	public void delete(Purchase purchase) throws SQLException;

}
