package com.entrecine4.persistence;

import java.sql.SQLException;
import java.util.List;

import com.entrecine4.model.Movie;

//TODO:This is a sample declaration of a DAO, there's no javadoc until this is a final declaration
public interface MovieDAO 
{
	public Movie get(long movieId) throws SQLException;
	public List<Movie> getAll() throws SQLException;
	public void save(Movie movie) throws SQLException;
	public void update(Movie movie) throws SQLException;
	public void delete(Movie movie) throws SQLException;
}
