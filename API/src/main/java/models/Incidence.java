package models;

import java.util.Date;

public class Incidence
{
	private long id;
	private long roomId;
	private Date day;
	private long sessionId;
	private String description;
	
	/**
	 * Constructor without parameters
	 */
	public Incidence()
	{
	}
	
	/**
	 * Constructor with parameters using all the fields
	 * 
	 * @param id The incidence's identification number
	 * @param roomId The room's identification number
	 * @param day The incidence's day
	 * @param sessionId The session's identification number affected by the incidence
	 * @param description A description of the incidence
	 */
	public Incidence(long id, long roomId, Date day, long sessionId, String description)
	{
		this.id=id;
		this.roomId = roomId;
		this.day = day;
		this.sessionId = sessionId;
		this.description = description;
	}
	
	/**
	 * Getter for the incidence's identification number
	 * 
	 * @return The incidence's identification number
	 */
	public long getId() {
		return id;
	}

	/**
	 * Setter for the incidence's identification number
	 * 
	 * @param id The new incidence's identification number
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter for the room's identification number
	 * 
	 * @return The room's identification number
	 */
	public long getRoomId() 
	{
		return roomId;
	}
	
	/**
	 * Setter for the room's identification number
	 * 
	 * @param roomId The new room's identification number
	 */
	public void setRoomId(long roomId) 
	{
		this.roomId = roomId;
	}
	
	/**
	 * Getter for the incidence's day
	 * 
	 * @return The incidence's day
	 */
	public Date getDay() 
	{
		return day;
	}
	
	/**
	 * Setter for the incidence's day
	 * 
	 * @param day The new incidence's day
	 */
	public void setDay(Date day) 
	{
		this.day = day;
	}
	
	/**
	 * Getter for the session affected by the incidence
	 * 
	 * @return The session's identification number affected by the incidence
	 */
	public long getSessionId() 
	{
		return sessionId;
	}
	
	/**
	 * Setter for the session affected by the incidence
	 * 
	 * @param sessionId The new session's identification number affected by the incidence
	 */
	public void setSessionId(long sessionId) 
	{
		this.sessionId = sessionId;
	}
	
	/**
	 * Getter for the description/cause of the incidence
	 * 
	 * @return The description/cause of the incidence
	 */
	public String getDescription() 
	{
		return description;
	}
	
	/**
	 * Setter for the description/cause of the incidence
	 * 
	 * @param description The new description/cause of the incidence
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return day.toString();
	}
}