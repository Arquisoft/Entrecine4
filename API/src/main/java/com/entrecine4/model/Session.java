package com.entrecine4.model;

import java.util.Date;

@SuppressWarnings("unused")
public class Session
{
	private long id;
	private String movieTitle;
	private Date day;
	private double time;		//Session's hour: 12:00/17:00/20:00/22:00
	private long roomId;
	
	private static final double TWELVE=12;
	private static final double SEVENTEEN=17;
	private static final double TWENTY=20;
	private static final double TWENTY_TWO=22;
	
	/**
	 * Constructor without parameters
	 */
	public Session()
	{
	}
	
	/**
	 * Constructor with parameters using all the fields
	 * 
	 * @param movieTitle Movie's title
	 * @param day Session's day
	 * @param time Session's hour
	 * @param roomId Room's identification number where it's going to be shown the movie
	 */
	public Session(long id, String movieTitle, Date day, double time, long roomId)
	{
		this.id=id;
		this.movieTitle = movieTitle;
		this.day = day;
		this.time = time;
		this.roomId = roomId;
	}
	
	/**
	 * Getter for the session's identification number
	 * 
	 * @return The session's identification number
	 */
	public long getId() {
		return id;
	}

	/**
	 * Setter for the session's identification number
	 * 
	 * @param id The new session's identification number
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter for the movie's title
	 * 
	 * @return The movie's title
	 */
	public String getMovieTitle() 
	{
		return movieTitle;
	}
	
	/**
	 * Setter for the movie's title
	 * 
	 * @param movieTitle The new movie's title for the session
	 */
	public void setMovieTitle(String movieTitle) 
	{
		this.movieTitle = movieTitle;
	}
	
	/**
	 * Getter for the session's day
	 * 
	 * @return The day of the session
	 */
	public Date getDay() 
	{
		return day;
	}
	
	/**
	 * Setter for the session's day
	 * 
	 * @param day The new session's day
	 */
	public void setDay(Date day)
	{
		this.day = day;
	}
	
	/**
	 * Getter for the session's hour
	 * 
	 * @return The session's hour (12:00/17:00/20:00/22:00)
	 */
	public double getTime()
	{
		return time;
	}
	
	/**
	 * Setter for the session's hour
	 * 
	 * @param time The new session's hour
	 */
	public void setTime(double time) 
	{
		this.time = time;
	}
	
	/**
	 * Getter for the room where it's going to be shown the movie
	 * 
	 * @return The room's identification number where it's going to be shown the movie
	 */
	public long getRoomId() 
	{
		return roomId;
	}
	
	/**
	 * Setter for the room where it's going to be shown the movie
	 * 
	 * @param roomId The new room's identification number where it's going to be shown the movie
	 */
	public void setRoomId(long roomId) 
	{
		this.roomId = roomId;
	}
}
