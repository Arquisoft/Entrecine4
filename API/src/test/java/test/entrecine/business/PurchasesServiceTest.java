package test.entrecine.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import models.Purchase;

import org.junit.Test;

import com.entrecine4.business.PurchasesService;
import com.entrecine4.infraestructure.Factories;

public class PurchasesServiceTest 
{
	private PurchasesService service = Factories.services.createPurchasesService();
	
	/**
	 * Method that tests the recovering of all customer's purchases stored in the
	 * database
	 */
	@Test
	public void testGetAllPurchases() 
	{
		List<Purchase> purchases = service.getPurchases();
		
		assertEquals(45, purchases.get(0).getId());
		assertEquals(46, purchases.get(1).getId());
	}
	
	/**
	 * Method that tests the recovering of a purchase using its identification number
	 */
	@Test
	public void testFindByID()
	{
		Purchase purchase = service.findPurchaseById(45L);
		
		assertEquals(1, purchase.getUser_id());
		assertEquals(1, purchase.getMovie_id());
		assertEquals("1;1;1;ekdf83k2ld", purchase.getTicket_id_code());
		assertEquals(0, purchase.getPaid());
		assertEquals(0, purchase.getCollected());
	}
	
	/**
	 * Method that tests the recovering of the purchases of a user using the
	 * user's identification number
	 */
	@Test
	public void testFindByUser()
	{
		Purchase purchase = service.findPurchasesUser(1).get(0);
		
		assertEquals(1, purchase.getUser_id());
		assertEquals(1, purchase.getMovie_id());
		assertEquals("1;1;1;ekdf83k2ld", purchase.getTicket_id_code());
		assertEquals(0, purchase.getPaid());
		assertEquals(0, purchase.getCollected());
	}
	
	/**
	 * Method that tests the recovering of a purchase using the ticket code
	 */
	@Test
	public void testFindByTicket()
	{
		Purchase purchase = service.findByTicketCode("1;2;5;ekdf83k2ld");
		
		assertEquals(2, purchase.getUser_id());
		assertEquals(2, purchase.getMovie_id());
		assertEquals("1;2;5;ekdf83k2ld", purchase.getTicket_id_code());
		assertEquals(1, purchase.getPaid());
		assertEquals(0, purchase.getCollected());
	}
	
	/**
	 * Method that tests the saving of a purchase into the database, checks if
	 * the saving was correct, and finally deletes it from the database
	 */
	@Test
	public void testSaveDeletePurchase()
	{
		Purchase purchase = new Purchase(0,1,2, "fakeTicket", 0, 0);
		service.savePurchase(purchase);
		
		List<Purchase> purchases = service.getPurchases();
		Long id = purchases.get(purchases.size()-1).getId();
		
		Purchase savedPurchase = service.findPurchaseById(id);
		
		assertEquals(purchase.getUser_id(), savedPurchase.getUser_id());
		assertEquals(purchase.getMovie_id(), savedPurchase.getMovie_id());
		assertEquals(purchase.getTicket_id_code(), savedPurchase.getTicket_id_code());
		assertEquals(purchase.getPaid(), savedPurchase.getPaid());
		assertEquals(purchase.getCollected(), savedPurchase.getCollected());
		
		service.deletePurchase(savedPurchase);
		
		Purchase deletedPurchase = service.findPurchaseById(id);
		assertEquals(null, deletedPurchase);
	}
	
	/**
	 * Method that tests the updating of purchase's data, checks if the updating
	 * was correct, and finally updates it back to the initial data
	 */
	@Test
	public void testUpdatePurchase()
	{
		Purchase purchase = service.findPurchaseById(45L);
		
		assertEquals(1, purchase.getUser_id());
		assertEquals(1, purchase.getMovie_id());
		assertEquals("1;1;1;ekdf83k2ld", purchase.getTicket_id_code());
		assertEquals(0, purchase.getPaid());
		assertEquals(0, purchase.getCollected());
		
		purchase.setCollected(1);
		purchase.setPaid(1);
		
		service.updatePurchase(purchase);
		Purchase updatedPurchase = service.findPurchaseById(45L);
		
		assertEquals(purchase.getUser_id(), updatedPurchase.getUser_id());
		assertEquals(purchase.getMovie_id(), updatedPurchase.getMovie_id());
		assertEquals(purchase.getTicket_id_code(), updatedPurchase.getTicket_id_code());
		assertEquals(purchase.getPaid(), updatedPurchase.getPaid());
		assertTrue(0!=updatedPurchase.getCollected());
		assertEquals(1, updatedPurchase.getCollected());
		
		purchase.setCollected(0);
		purchase.setPaid(0);
		service.updatePurchase(purchase);
	}

}
