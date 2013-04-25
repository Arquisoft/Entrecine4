package com.entrecine4.persistence;

public interface PersistenceFactory 
{
	/**
	 * Method to get an instance of EmployeeDAO and get access to the database's employees table
	 * 
	 * @return An instance of EmployeeDAO
	 */
	public EmployeeDAO createEmployeeDAO();
	
	/**
	 * Method to get an instance of IncidenceDAO and get access to the database's incidences table
	 * 
	 * @return
	 */
	public IncidenceDAO createIncidenceDAO();
	
	/**
	 * Method to get an instance of MovieDAO and get access to the database's movies table
	 * 
	 * @return An instance of MovieDAO
	 */
	public MovieDAO createMovieDAO();
	
	/**
	 * Method to get an instance of PurchaseDAO and get access to the database's purchases table
	 * 
	 * @return An instance of PurchaseDAO
	 */
	public PurchaseDAO createPurchaseDAO();
	
	/**
	 * Method to get an instance of RoomDAO and get access to the database's rooms table
	 * 
	 * @return An instance of RoomDAO
	 */
	public RoomDAO createRoomDAO();
	
	/**
	 * Method to get an instance of SessionDAO and get access to the database's sessions table
	 * 
	 * @return An instance of SessionDAO
	 */
	public SessionDAO createSessionDAO();
	
	/**
	 * Method to get an instance of SessionStateDAO and get access to the database's session 
	 * states table
	 * 
	 * @return An instance of SessionStateDAO
	 */
	public SessionStateDAO createSessionStateDAO();
	
	/**
	 * Method to get an instance of UserDAO and get access to the database's users table
	 * 
	 * @return An instance of UserDAO
	 */
	public UserDAO createUserDAO();
}
