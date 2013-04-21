package com.entrecine4.model;

import java.util.Date;

public class Incidence
{
	private long roomId;
	private Date day;
	private Session session;
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
	 * @param roomId The room's identification number
	 * @param day The incidence's day
	 * @param session The session affected by the incidence
	 * @param description A description of the incidence
	 */
	public Incidence(long roomId, Date day, Session session, String description)
	{
		this.roomId = roomId;
		this.day = day;
		this.session = session;
		this.description = description;
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
	 * @return The session affected by the incidence
	 */
	public Session getSession() 
	{
		return session;
	}
	
	/**
	 * Setter for the session affected by the incidence
	 * 
	 * @param session The new session affected by the incidence
	 */
	public void setSession(Session session) 
	{
		this.session = session;
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
}