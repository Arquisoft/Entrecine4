package com.entrecine4.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.entrecine4.model.Movie;

public interface MovieDAO 
{
	/**
	 * Method to set the connection that the DAO will use
	 * 
	 * @param connection
	 */
	public void setConnection(Connection connection);
	
	/**
	 * Method to get a movie from the database using an id
	 * 
	 * @param movieId
	 * @return The requested movie
	 * @throws SQLException
	 */
	public Movie get(long movieId) throws SQLException;
	
	/**
	 * Method to get all the movies from the database
	 * 
	 * @return A list with all the movies
	 * @throws SQLException
	 */
	public List<Movie> getAll() throws SQLException;
	
	/**
	 * Method to save a movie in the database
	 * 
	 * @param movie The instance of Movie to be saved
	 * @throws SQLException
	 */
	public void save(Movie movie) throws SQLException;
	
	/**
	 * Method to update the data of a movie in the database
	 * 
	 * @param movie The instance of Movie to be updated
	 * @throws SQLException
	 */
	public void update(Movie movie) throws SQLException;
	
	/**
	 * Method to delete a movie from the database
	 * 
	 * @param movie The instance of Movie to be deleted from the database
	 * @throws SQLException
	 */
	public void delete(Movie movie) throws SQLException;
}
