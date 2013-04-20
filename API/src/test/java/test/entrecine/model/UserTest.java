package test.entrecine.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.entrecine4.model.User;

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

	/**
	 * Test without parameters, this will test setters
	 */
	@Test
	public void testWithoutParameters() {
		user1 = new User();
		user1.setId(ID);
		user1.setUsername(USERNAME);
		user1.setPassword(PASSWORD);
		testAttributes(user1);
	}
	
	/**
	 * Test with parameters, this will test getters and parameterized constructor
	 */
	@Test
	public void testWithParameters() {
		user2 = new User(ID, USERNAME, PASSWORD);
		testAttributes(user2);
	}

	/**
	 * Method for test the attributes
	 * @param the user to test
	 */
	private void testAttributes(User user) {
		assertEquals(user.getId(), ID);
		assertEquals(user.getUsername(), USERNAME);
		assertEquals(user.getPassword(), PASSWORD);
	}

}
