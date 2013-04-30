package test.entrecine.model;

import static org.junit.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import models.Movie;

import org.junit.Test;


public class MovieTest 
{
	private Movie movie;
	
	private static final long ID=1L;
	private static final String NAME="Matrix";
	private static final String SYNOPSIS="Thomas A. Anderson is a programmer, but he wonders who is Morpheo...";
	private static final String IMG_PATH="/img/matrix.png";
	private static double MORNING_PRICE=5.65;
	private static double DAILY_PRICE=6.65;
	private static double NIGHT_PRICE=8.65;
	private static String GENRE="Fiction";
	
	
	/**
	 * Method to test setters of com.entrecine4.model.Movie.java
	 */
	@Test
	public void testWithoutParameters()
	{
		movie=new Movie();
		movie.setId(ID);
		movie.setName(NAME);
		movie.setSynopsis(SYNOPSIS);
		movie.setImgPath(IMG_PATH);
		movie.setMorningPrice(MORNING_PRICE);
		movie.setDailyPrice(DAILY_PRICE);
		movie.setNightPrice(NIGHT_PRICE);
		movie.setGenre(GENRE);
		
		testAttributes(movie);
	}
	
	/**
	 * Method to test getters and constructor with parameters of com.entrecine4.model.Movie.java
	 */
	@Test
	public void testWithParameters()
	{
		movie=new Movie(ID, NAME, SYNOPSIS, IMG_PATH, MORNING_PRICE, DAILY_PRICE, NIGHT_PRICE, GENRE);
		
		testAttributes(movie);
	}

	/**
	 * Method for test the attributes
	 * @param The movie to test
	 */
	private void testAttributes(Movie movie)
	{
		assertEquals(ID, movie.getId());
		assertEquals(NAME,movie.getName());
		assertEquals(SYNOPSIS, movie.getSynopsis());
		assertEquals(IMG_PATH, movie.getImgPath());
		assertTrue(MORNING_PRICE==movie.getMorningPrice());
		assertTrue(DAILY_PRICE==movie.getDailyPrice());
		assertTrue(NIGHT_PRICE==movie.getNightPrice());
		assertEquals(GENRE, movie.getGenre());
	}

}