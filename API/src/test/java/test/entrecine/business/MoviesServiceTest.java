package test.entrecine.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import models.Movie;

import org.junit.Test;

import com.entrecine4.business.MoviesService;
import com.entrecine4.infraestructure.Factories;

public class MoviesServiceTest 
{
	private MoviesService service = Factories.services.createMoviesService();
	
	/**
	 * Method that tests the recovering of all the movies stored in the database
	 */
	@Test
	public void testGetAllMovies() 
	{
		List<Movie> movies = service.getMovies();
		
		assertEquals(1, movies.get(0).getId());
		assertEquals("Ironman 3", movies.get(0).getName());
	}
	
	/**
	 * Method that tests the recovering of a movie using its identification number
	 */
	@Test
	public void testFindByID()
	{
		Movie movie = service.findById(2L);
		String synopsis = "El pececillo Nemo, que es hijo único, es muy querido" +
				" y protegido por su padre. Después de ser capturado en un arrecife" +
				" australiano va a parar a la pecera de la oficina de un dentista de" +
				" Sidney. Su tímido padre emprenderá una peligrosa aventura para " +
				"rescatarlo. Pero Nemo y sus nuevos amigos tienen también un astuto " +
				"plan para escapar de la pecera y volver al mar.";
		
		assertEquals("Buscando a Nemo 3d", movie.getName());
		assertEquals(synopsis, movie.getSynopsis());
		assertEquals("buscando_a_nemo_3d.jpg", movie.getImgPath());
		assertTrue(8==movie.getMorningPrice());
		assertTrue(80==movie.getDailyPrice());
		assertTrue(20==movie.getNightPrice());
		assertEquals("Animación", movie.getGenre());
	}
	
	@Test
	public void testFindByTitle()
	{
		Movie movie = service.findByTitle("Buscando a Nemo 3d");
		String synopsis = "El pececillo Nemo, que es hijo único, es muy querido" +
				" y protegido por su padre. Después de ser capturado en un arrecife" +
				" australiano va a parar a la pecera de la oficina de un dentista de" +
				" Sidney. Su tímido padre emprenderá una peligrosa aventura para " +
				"rescatarlo. Pero Nemo y sus nuevos amigos tienen también un astuto " +
				"plan para escapar de la pecera y volver al mar.";
		
		assertEquals("Buscando a Nemo 3d", movie.getName());
		assertEquals(synopsis, movie.getSynopsis());
		assertEquals("buscando_a_nemo_3d.jpg", movie.getImgPath());
		assertTrue(8==movie.getMorningPrice());
		assertTrue(80==movie.getDailyPrice());
		assertTrue(20==movie.getNightPrice());
		assertEquals("Animación", movie.getGenre());
	}
	
	/**
	 * Method that tests the saving of a movie into the database, checks if the saving
	 * was correct, and finally deletes it from the database
	 */
	@Test
	public void testSaveDeleteMovie()
	{
		String synopsis = "Historia de la vida del afroamericano Jackie Robinson " +
				"(Chadwick Boseman), legendario jugador de béisbol que rompió las " +
				"barreras raciales, tras firmar con los Dodgers de Brooklyn bajo " +
				"la dirección del ejecutivo Branch Rickey (Harrison Ford). La " +
				"participación de Robinson en la gran liga de béisbol supuso el fin de " +
				"una era de segregación racial en este deporte.";
		Movie movie = new Movie(0, "42", synopsis, "42.jpg", 5, 10, 20, "Drama");
		service.saveMovie(movie);
		
		List<Movie> movies = service.getMovies();
		Long id = movies.get(movies.size()-1).getId();
		
		Movie savedMovie = service.findById(id);
		
		assertEquals(movie.getName(), savedMovie.getName());
		assertEquals(movie.getSynopsis(), savedMovie.getSynopsis());
		assertEquals(movie.getImgPath(), savedMovie.getImgPath());
		assertTrue(movie.getMorningPrice()==savedMovie.getMorningPrice());
		assertTrue(movie.getDailyPrice()==savedMovie.getDailyPrice());
		assertTrue(movie.getNightPrice()==savedMovie.getNightPrice());
		assertEquals(movie.getGenre(), savedMovie.getGenre());
		
		service.deleteMovie(savedMovie);
		
		Movie deletedMovie = service.findById(id);
		assertEquals(null, deletedMovie);
	}
	
	/**
	 * Method that tests the updating of movie's data, checks if the updating
	 * was correct, and finally updates it back to the initial data
	 */
	@Test
	public void testUpdateMovie()
	{
		Movie movie = service.findById(2L);
		String synopsis = "El pececillo Nemo, que es hijo único, es muy querido" +
				" y protegido por su padre. Después de ser capturado en un arrecife" +
				" australiano va a parar a la pecera de la oficina de un dentista de" +
				" Sidney. Su tímido padre emprenderá una peligrosa aventura para " +
				"rescatarlo. Pero Nemo y sus nuevos amigos tienen también un astuto " +
				"plan para escapar de la pecera y volver al mar.";
		
		assertEquals("Buscando a Nemo 3d", movie.getName());
		assertEquals(synopsis, movie.getSynopsis());
		assertEquals("buscando_a_nemo_3d.jpg", movie.getImgPath());
		assertTrue(8==movie.getMorningPrice());
		assertTrue(80==movie.getDailyPrice());
		assertTrue(20==movie.getNightPrice());
		assertEquals("Animación", movie.getGenre());
		
		movie.setGenre("Terror");
		movie.setMorningPrice(2);
		
		service.updateMovie(movie);
		Movie updatedMovie = service.findById(2L);
		
		assertEquals(movie.getName(), updatedMovie.getName());
		assertEquals(movie.getSynopsis(), updatedMovie.getSynopsis());
		assertEquals(movie.getImgPath(), updatedMovie.getImgPath());
		assertTrue(movie.getMorningPrice()==updatedMovie.getMorningPrice());
		assertTrue(movie.getDailyPrice()==updatedMovie.getDailyPrice());
		assertTrue(movie.getNightPrice()==updatedMovie.getNightPrice());
		assertEquals(movie.getGenre(), updatedMovie.getGenre());
		
		movie.setGenre("Animación");
		movie.setMorningPrice(8);
		service.updateMovie(movie);
	}

}
