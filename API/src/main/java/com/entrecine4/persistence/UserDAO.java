package com.entrecine4.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.User;


/**
 * User's dao interface
 * @author Arquisoft - Entrecine4
 *
 */
public interface UserDAO {
	
	/**
	 * Set the conecction to use
	 * @param connection
	 */
	void setConnection(Connection con);
	
	/**
	 * Returns the user requested by id
	 * @param id
	 * @return the requested user
	 */
	User get(long id) throws SQLException;
	
	/**
	 * Returns the user requested by username
	 * @param username
	 * @return the requested user
	 */
	User get(String username) throws SQLException;
	
	/**
	 * Returns all the existing users
	 * @return all the users
	 */
	List<User> getAll() throws SQLException;
	
	/**
	 * Save the given user
	 * @param user
	 */
	void save(User user) throws SQLException;
	
	/**
	 * Update the existing user according to id in the given user, this will update the other fields if this make sense
	 * @param user
	 */
	void update(User user) throws SQLException;
	
	/**
	 * Delete the existing user, this method will only take the given id in the user
	 * @param user
	 */
	void delete(User user) throws SQLException;

}
