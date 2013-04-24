package com.entrecine4.persistence;

//TODO: No javadoc yet
public interface PersistenceFactory 
{
	public EmployeeDAO createEmployeeDAO();
	public IncidenceDAO createIncidenceDAO();
	public MovieDAO createMovieDAO();
	public PurchaseDAO createPurchaseDAO();
	public RoomDAO createRoomDAO();
	public SessionDAO createSessionDAO();
	public SessionStateDAO createSessionStateDAO();
	public UserDAO createUserDAO();
}
