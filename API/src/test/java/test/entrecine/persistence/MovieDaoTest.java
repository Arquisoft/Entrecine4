package test.entrecine.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import impl.entrecine4.persistence.MovieJdbcDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.Movie;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.persistence.MovieDAO;

public class MovieDaoTest
{
	private static MovieDAO dao=new MovieJdbcDAO();
	private static Connection con=Jdbc.getConnection();

	/**
	 * Method before all test
	 * 
	 * @throws SQLException
	 */
	@BeforeClass
	public static void setUp() throws SQLException {
		dao.setConnection(con);
		con.setAutoCommit(false);
	}
	
	/**
	 * Method to test the insertion of the same movie twice. It must fail
	 * 
	 * @throws SQLException
	 */
	public void testInsertTwo() throws SQLException {
		Movie movie = new Movie(1L, "Movie", "Just a movie", "/img/movie.png"
				,1D, 1D, 1D, "Fiction");
		dao.save(movie);
		dao.save(movie);
	}

	/**
	 * Method to test the insertion and deletion of a movie
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testSaveAndDelete() throws SQLException {
		Movie movie = new Movie(1L, "Movie", "Just a movie", "/img/movie.png", 1D, 1D, 1D,"Comedy");
		dao.save(movie);
		
		List<Movie> temp=dao.getAll();
		
		Movie recoveredMovie = dao.get(temp.get(temp.size()-1).getId());
		assertEquals(movie.getName(), recoveredMovie.getName());
		assertEquals(movie.getSynopsis(), recoveredMovie.getSynopsis());
		assertEquals(movie.getImgPath(), recoveredMovie.getImgPath());
		assertTrue(movie.getMorningPrice()==recoveredMovie.getMorningPrice());
		assertTrue(movie.getDailyPrice()==recoveredMovie.getDailyPrice());
		assertTrue(movie.getNightPrice()==recoveredMovie.getNightPrice());
		
		dao.delete(movie);
		assertEquals(null, dao.get(1));
	}

	/**
	 * Method to test the recovering of a movie that doesn't exist in the database
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetBadId() throws SQLException {
		Movie movie = dao.get(-1);
		assertEquals(null, movie);
	}

	/**
	 * Method to test the update operation of a movie
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException {
		Movie movie = new Movie(1L, "Movie", "Just a movie", "/img/movie.png", 1D, 1D, 1D,"Fiction");
		dao.save(movie);
		movie.setName("Movie 2");

		List<Movie> temp=dao.getAll();
		movie.setId(temp.get(temp.size()-1).getId());
		dao.update(movie);
		
		Movie recoveredMovie = dao.get(temp.get(temp.size()-1).getId());

		assertEquals("Movie 2",recoveredMovie.getName());
	}

	/**
	 * Method after all tests
	 * 
	 * @throws SQLException
	 */
	@AfterClass
	public static void setDown() throws SQLException {
		con.rollback();
		con.close();
	}
}
