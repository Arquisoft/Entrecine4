package com.entrecine4.model;

/**
 * User model class, this class will also work as DTO
 * @author Arquisoft - Entrecine 4
 */
public class User {
	
	private long id;
	private String username;
	private String password;
	
	/**
	 * Constructor without parameters
	 */
	public User() {}

	/**
	 * Constructor with all parameters
	 * @param id
	 * @param username
	 * @param password
	 */
	public User(long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
		// if this constructor is not necessary, just remove it
	}

	/**
	 * Getter for id property
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Setter for id property
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter for username property
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter for username property
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter for password property
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for password property
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
