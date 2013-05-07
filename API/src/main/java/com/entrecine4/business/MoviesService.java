package com.entrecine4.business;

import java.util.List;

import models.Movie;

public interface MoviesService {
	
	/**
	 * Retrieve all the movies
	 * @return the movies
	 */
	public List<Movie> getMovies();
	
	/**
	 * Retrieve one movie
	 * @param id
	 * 			Movie ID	
	 * @return the movie
	 */
	public Movie findById(Long id);
	
	/**
	 * Retrieve on movie using its title
	 * @param title Movie's name
	 * @return
	 */
	public Movie findByTitle(String title);

	/**
	 * Save a move
	 * @param movie
	 * 				Movie to be saved
	 */
	public void saveMovie(Movie movie);
	
	/**
	 * Update a movie
	 * @param movie
	 * 				Movie to be updated
	 */
	public void updateMovie(Movie movie);
	
	/**
	 * Delete a movie
	 * @param movie
	 * 				Movie to be deleted
	 */
	public void deleteMovie(Movie movie);

    /**
     * Return the price of the movie depending on the show time
     * @param movie
     * @param time
     * @return price
     */
    public double getPrice(Movie movie, double time);

}