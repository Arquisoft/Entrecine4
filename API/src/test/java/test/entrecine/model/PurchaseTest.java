package test.entrecine.model;

import static org.junit.Assert.*;


import models.Purchase;

import org.junit.Test;



public class PurchaseTest {

private Purchase purchase1, purchase2;
	
public final static long ID = 1, USER_ID = 2, MOVIE_ID = 3;
public final static String TICKET_ID_CODE = "123456789qwerty";
public final static int PAID = 1, COLLECTED = 0;
	
	/**
	 * Test without parameters, this will test setters
	 */
	@Test
	public void testWithoutParameters() {
		purchase1 = new Purchase();
		purchase1.setId(ID);
		purchase1.setId(ID);
		purchase1.setUser_id(USER_ID);
		purchase1.setMovie_id(MOVIE_ID);
		purchase1.setTicket_id_code(TICKET_ID_CODE);
		purchase1.setPaid(PAID);
		purchase1.setCollected(COLLECTED);
		testAttributes(purchase1);
	}
	
	/**
	 * Test with parameters, this will test getters and constructor with parameters
	 */
	@Test
	public void testWithParameters() {
		purchase2 = new Purchase(ID, USER_ID, MOVIE_ID, TICKET_ID_CODE, PAID, COLLECTED);
		testAttributes(purchase2);
	}

	/**
	 * Method for test the attributes
	 * @param the employee to test
	 */
	private void testAttributes(Purchase p) {
		assertEquals(ID, p.getId());
		assertEquals(USER_ID, p.getUser_id());
		assertEquals(MOVIE_ID, p.getMovie_id());
		assertEquals(TICKET_ID_CODE, p.getTicket_id_code());
		assertEquals(PAID, p.getPaid());
		assertEquals(COLLECTED, p.getCollected());
		
		
	}


}
