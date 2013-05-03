package com.entrecine4.infraestructure;

import java.util.List;

import models.User;

public interface UserService 
{
	/**
	 * Returns the user if username exists in the DB and the password is correct
	 * @param username User's username
	 * @param password User's password
	 * @return the user
	 */
	public User login(String username, String password);
	
	/**
	 * Returns the user requested by id
	 * 
	 * @param id
	 * @return the requested user
	 */
	User get(long id) throws RuntimeException;

	/**
	 * Returns the user requested by username
	 * 
	 * @param username
	 * @return the requested user
	 */
	User get(String username) throws RuntimeException;

	/**
	 * Returns all the existing users
	 * 
	 * @return all the users
	 */
	List<User> getAll() throws RuntimeException;

	/**
	 * Save the given user
	 * 
	 * @param user
	 */
	void save(User user) throws RuntimeException;

	/**
	 * Update the existing user according to id in the given user, this will
	 * update the other fields if this make sense
	 * 
	 * @param user
	 */
	void update(User user) throws RuntimeException;

	/**
	 * Delete the existing user, this method will only take the given id in the
	 * user
	 * 
	 * @param user
	 */
	void delete(User user) throws RuntimeException;
}
