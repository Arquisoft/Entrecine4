package test.entrecine.model;

import static org.junit.Assert.assertEquals;
import models.User;

import org.junit.Test;


/**
 * Test for User in model
 * @author Arquisoft - Entrecine4
 *
 */
public class UserTest {
	
	private User user1;
	private User user2;
	
	private final static long ID = 1;
	private final static String USERNAME = "pepito59";
	private final static String PASSWORD = "mystrongpass";
	private final static String NAME="pepe";
	private final static String SURNAMES="pe pe";
	private final static String EMAIL="pepe@pepito.com";

	/**
	 * Test without parameters, this will test setters
	 */
	@Test
	public void testWithoutParameters() {
		user1 = new User();
		user1.setId(ID);
		user1.setUsername(USERNAME);
		user1.setPassword(PASSWORD);
		user1.setName(NAME);
		user1.setSurnames(SURNAMES);
		user1.setEmail(EMAIL);
		testAttributes(user1);
	}
	
	/**
	 * Test with parameters, this will test getters and parameterized constructor
	 */
	@Test
	public void testWithParameters() {
		user2 = new User(ID, USERNAME, PASSWORD, NAME, SURNAMES, EMAIL);
		testAttributes(user2);
	}

	/**
	 * Method for test the attributes
	 * @param the user to test
	 */
	private void testAttributes(User user) {
		assertEquals(ID, user.getId());
		assertEquals(USERNAME, user.getUsername());
		assertEquals(PASSWORD, user.getPassword());
		assertEquals(NAME, user.getName());
		assertEquals(SURNAMES, user.getSurnames());
		assertEquals(EMAIL, user.getEmail());
	}

}
