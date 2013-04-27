package com.entrecine4.model;

public class Employee {

	private long id;
	private String username;
	private String password;
	private int isAdmin; // DB contains 0 or 1 instead of booleans

	/**
	 * Constructor with all the fields
	 * 
	 * @param id
	 *            Employee's identification number
	 * @param username
	 *            Username
	 * @param password
	 *            Password of the user
	 * @param isAdmin
	 *            contains 0 or 1 depending on whether the user is an
	 *            administrator or not
	 */
	public Employee(long id, String username, String password, int isAdmin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	/**
	 * Constructor without parameters
	 */
	public Employee() {
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isAdmin
	 */
	public int getIsAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin
	 *            the isAdmin to set
	 */
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

}
