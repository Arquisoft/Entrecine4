package com.entrecine4.infraestructure;

import java.util.List;

import com.entrecine4.model.User;

public interface UserService {

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
