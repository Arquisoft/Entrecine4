package impl.entrecine4.business;

import impl.entrecine4.persistence.SimplePersistenceFactory;

import java.sql.SQLException;
import java.util.List;

import com.entrecine4.business.MoviesService;
import com.entrecine4.model.Movie;
import com.entrecine4.persistence.MovieDAO;

public class SimpleMoviesService implements MoviesService {

	private MovieDAO dao = new SimplePersistenceFactory().createMovieDAO();

	@Override
	public List<Movie> getMovies() {
		try {
			return dao.getAll();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public Movie findById(Long id) {
		try {
			return dao.get(id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void saveMovie(Movie movie) {
		try {
			dao.save(movie);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void updateMovie(Movie movie) {
		try {
			dao.update(movie);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void deleteMovie(Movie movie) {
		try {
			dao.delete(movie);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
