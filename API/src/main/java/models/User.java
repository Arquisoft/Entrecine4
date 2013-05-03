package models;

/**
 * User model class, this class will also work as DTO
 * 
 * @author Arquisoft - Entrecine 4
 */
public class User {

	private long id;
	private String username;
	private String password;
	private String name;
	private String surnames;
	private String email;

	/**
	 * Constructor without parameters
	 */
	public User() {
	}

	/**
	 * Constructor with all parameters
	 * 
	 * @param id
	 * @param username
	 * @param password
	 * @param name
	 * @param surnames
	 * @param email
	 */
	public User(long id, String username, String password, String name
			, String surnames, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name=name;
		this.surnames=surnames;
		this.email=email;
	}

	/**
	 * Getter for id property
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Setter for id property
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter for username property
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter for username property
	 * 
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter for password property
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for password property
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Check if any field is empty
	 * 
	 * @return true if there's any empty field
	 */
	public boolean hasEmptyFields() {
		if (id <0  || username == null || password == null
				|| name == null || surnames == null || email == null)
			return true;
		return false;
	}

	/**
	 * Getter for name property
	 * 
	 * @return the name of the user
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name property
	 * 
	 * @param name
	 * 			the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for surnames property
	 * 
	 * @return the user's surnames
	 */
	public String getSurnames() {
		return surnames;
	}

	/**
	 * Setter for surnames property
	 * 
	 * @param surnames
	 * 			the surnames to set
	 */
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	/**
	 * Getter for email property
	 * 
	 * @return the user's email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter for email property
	 * 
	 * @param email
	 * 			the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
