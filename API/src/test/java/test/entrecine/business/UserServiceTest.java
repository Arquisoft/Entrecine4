package test.entrecine.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import models.User;

import org.junit.Test;

import com.entrecine4.infraestructure.Factories;
import com.entrecine4.infraestructure.UserService;

public class UserServiceTest 
{
	private UserService service = Factories.services.createUserService();
	
	/**
	 * Test for the method getAll() of the UserService
	 */
	@Test
	public void testGetAllUsers() 
	{
		List<User> users = service.getAll();
		
		assertEquals(17, users.get(0).getId());
		assertEquals("pepito", users.get(0).getUsername());
		assertEquals(40, users.get(1).getId());
		assertEquals("paco", users.get(1).getUsername());
	}
	
	/**
	 * Test for find a user by his identification number
	 */
	@Test
	public void testFindByID()
	{
		User user = service.get(17);
		
		assertEquals("pepito", user.getUsername());
		assertEquals("pepito", user.getPassword());
		assertEquals("pepito", user.getName());
		assertEquals("pepito", user.getSurnames());
		assertEquals("pepito@pepito.com", user.getEmail());
	}
	
	/**
	 * Test for find a user by his username
	 */
	@Test
	public void testFindByUsername()
	{
		User user = service.get("pepito");
		
		assertEquals(17, user.getId());
		assertEquals("pepito", user.getUsername());
		assertEquals("pepito", user.getPassword());
		assertEquals("pepito", user.getName());
		assertEquals("pepito", user.getSurnames());
		assertEquals("pepito@pepito.com", user.getEmail());
	}
	
	/**
	 * Test that saves an user, check if the user was saved correctly, and then
	 * delete it from the database
	 */
	@Test
	public void testSaveDeleteUser()
	{
		User user = new User(0, "test4", "test", "TestName", "Test Surname", "t@t.com");
		service.save(user);
		
		List<User> users = service.getAll();
		Long id = users.get(users.size()-1).getId();
		
		User savedUser = service.get(id);
		
		assertEquals(user.getUsername(), savedUser.getUsername());
		assertEquals(user.getPassword(), savedUser.getPassword());
		assertEquals(user.getName(), savedUser.getName());
		assertEquals(user.getSurnames(), savedUser.getSurnames());
		assertEquals(user.getEmail(), savedUser.getEmail());
		
		service.delete(savedUser);
		
		User deletedUser = service.get(id);
		assertEquals(null, deletedUser);
	}
	
	/**
	 * Test for update a user's data, check if the updating was ok, and then
	 * update it again back to the initial data
	 */
	@Test
	public void testUpdateUser()
	{
		User user = service.get("pepito");
		
		assertEquals(17, user.getId());
		assertEquals("pepito", user.getUsername());
		assertEquals("pepito", user.getPassword());
		assertEquals("pepito", user.getName());
		assertEquals("pepito", user.getSurnames());
		assertEquals("pepito@pepito.com", user.getEmail());
		
		user.setName("pepi");
		user.setSurnames("pipa");
		
		service.update(user);
		User updatedUser = service.get(17);
		
		assertEquals(user.getUsername(), updatedUser.getUsername());
		assertEquals(user.getPassword(), updatedUser.getPassword());
		assertEquals(user.getName(), updatedUser.getName());
		assertEquals(user.getSurnames(), updatedUser.getSurnames());
		assertEquals(user.getEmail(), updatedUser.getEmail());
		
		user.setName("pepito");
		user.setSurnames("pepito");
		service.update(user);
	}
	
	@Test
	public void testLogin()
	{
		User user = service.login("pepito", "pepito");
		
		assertTrue(user!=null);
		assertEquals(17, user.getId());
		assertEquals("pepito", user.getUsername());
		assertEquals("pepito", user.getPassword());
		assertEquals("pepito", user.getName());
		assertEquals("pepito", user.getSurnames());
		assertEquals("pepito@pepito.com", user.getEmail());
		
		user = service.login("fakeUser", "fakePass");
		
		assertTrue(user==null);
	}

}
