package com.entrecine4.model;

import java.util.Date;

@SuppressWarnings("unused")
public class Session
{
	private String movieTitle;
	private Date day;
	private double time;		//Session's hour: 12:00/17:00/20:00/22:00
	private Room room;
	
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
	 * @param room Room where it's going to be shown the movie
	 */
	public Session(String movieTitle, Date day, double time, Room room)
	{
		this.movieTitle = movieTitle;
		this.day = day;
		this.time = time;
		this.room = room;
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
	 * @return The room where it's going to be shown the movie
	 */
	public Room getRoom() 
	{
		return room;
	}
	
	/**
	 * Setter for the room where it's going to be shown the movie
	 * 
	 * @param room The new room where it's going to be shown the movie
	 */
	public void setRoom(Room room) 
	{
		this.room = room;
	}
}