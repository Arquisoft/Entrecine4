package impl.entrecine4.business;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.infraestructure.Log;

import impl.entrecine4.persistence.SimplePersistenceFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.Movie;

import com.entrecine4.business.MoviesService;
import com.entrecine4.persistence.MovieDAO;

public class SimpleMoviesService implements MoviesService {

	private MovieDAO dao = new SimplePersistenceFactory().createMovieDAO();

	/* (non-Javadoc)
	 * @see com.entrecine4.business.MoviesService#getMovies()
	 */
	@Override
	public List<Movie> getMovies() {
        Connection con = Jdbc.getConnection();
		try {
            dao.setConnection(con);
			return dao.getAll();
		} catch (SQLException e) {
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
			throw new RuntimeException();
		} finally {
            Jdbc.close(con);
        }
    }

	/* (non-Javadoc)
	 * @see com.entrecine4.business.MoviesService#findById(java.lang.Long)
	 */
	@Override
	public Movie findById(Long id) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            return dao.get(id);
        } catch (SQLException e) {
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.MoviesService#findByTitle(java.lang.String)
	 */
	@Override
	public Movie findByTitle(String title) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			return dao.get(title);
		} catch (SQLException e) {
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
			throw new RuntimeException();
		} finally {
			Jdbc.close(con);
	    }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.MoviesService#saveMovie(com.entrecine4.model.Movie)
	 */
	@Override
	public void saveMovie(Movie movie) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.save(movie);
        } catch (SQLException e) {
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.MoviesService#updateMovie(com.entrecine4.model.Movie)
	 */
	@Override
	public void updateMovie(Movie movie) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.update(movie);
        } catch (SQLException e) {
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.MoviesService#deleteMovie(com.entrecine4.model.Movie)
	 */
	@Override
	public void deleteMovie(Movie movie) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.delete(movie);
        } catch (SQLException e) {
        	Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

    /* (non-Javadoc)
	 * @see com.entrecine4.business.MoviesService#getPrice(com.entrecine4.model.Movie)
	 */
    @Override
    public double getPrice(Movie movie, double time) {
        if(time == 12)
            return movie.getMorningPrice();
        else if(time == 17)
            return movie.getDailyPrice();
        else if(time == 20 || time == 22)
            return movie.getNightPrice();
        RuntimeException e = new RuntimeException("Invalid time of session for movies");
        Log.log("----TRACE----\n"+e.getStackTrace().toString()+"\n\n\n");
        throw e;
    }

}
