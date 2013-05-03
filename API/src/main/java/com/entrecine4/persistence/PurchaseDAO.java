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
	 * Returns a purchase using the generated ticket for that purchase
	 * @param ticketCode The generated ticket code
	 * @return The purchase for that ticket code if exists
	 * @throws SQLException
	 */
	public Purchase get(String ticketCode) throws SQLException;
	
	/**
	 * Returns a list of all the purchases
	 * @return
	 * @throws SQLException
	 */
	public List<Purchase> getAll() throws SQLException;
	
	/**
	 * Returns all the purchases of the supplied user
	 * 
	 * @param userId The user's identification number
	 * @return A list with the purchases for that user
	 * @throws SQLException
	 */
	public List<Purchase> getByUser(long userId) throws SQLException;
		
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
