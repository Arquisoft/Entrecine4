package com.entrecine4.business;

import java.util.List;

import models.Purchase;

public interface PurchasesService
{
	/**
	 * Return all the customer's purchases
	 * 
	 * @return A list with the customer's purchases
	 */
	public List<Purchase> getPurchases();
	
	/**
	 * Get an specific purchase using an identification number
	 * 
	 * @param id The identifier
	 * @return The required purchase
	 */
	public Purchase findPurchaseById(long id);
	
	/**
	 * Find all the purchases of a user, using the user's identification number
	 * 
	 * @param userId The user's identification number
	 * @return A list with the purchases
	 */
	public List<Purchase> findPurchasesUser(long userId);
	
	/**
	 * Get a purchase using the generated ticket that the user has received in his email.
	 * 
	 * @param ticketCode The ticket identifier
	 * @return The user's purchase
	 */
	public Purchase findByTicketCode(String ticketCode);
	
	/**
	 * Save a purchase in the system
	 * 
	 * @param purchase The purchase to save
	 */
	public void savePurchase(Purchase purchase);
	
	/**
	 * Update the data of a purchase in the system
	 * 
	 * @param purchase The purchase to update
	 */
	public void updatePurchase(Purchase purchase);
	
	/**
	 * Delete a purchase from the system
	 * 
	 * @param purchase The purchase to delete
	 */
	public void deletePurchae(Purchase purchase);
}