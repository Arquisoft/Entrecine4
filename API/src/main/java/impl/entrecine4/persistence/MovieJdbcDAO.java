package impl.entrecine4.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entrecine4.model.Movie;
import com.entrecine4.persistence.MovieDAO;

//TODO:No javadoc & JUnit yet
public class MovieJdbcDAO implements MovieDAO
{
	//Variables to use in the class and this way don't be defining all the time the same variables in each method
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.MovieDAO#get(long)
	 */
	@Override
	public Movie get(long movieId) throws SQLException 
	{
		Movie result=null;
		
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, movieId);
		
		rs=pst.executeQuery();
		if(rs.next())
		{
			result=new Movie();
			result.setId(movieId);
			result.setName(rs.getString("NOMBRE"));
			result.setSynopsis(rs.getString("SINOPSIS"));
			result.setImgPath(rs.getString("RUTA_IMAGEN_CARTEL"));
			result.setMorningPrice(rs.getDouble("PRECIO_MATUTINO"));
			result.setDailyPrice(rs.getDouble("PRECIO_DIARIO"));
			result.setNightPrice(rs.getDouble("PRECIO_NOCHE"));
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.MovieDAO#getAll()
	 */
	@Override
	public List<Movie> getAll() throws SQLException 
	{
		List<Movie> result=new ArrayList<Movie>();
		
		pst=connection.prepareStatement("SQL using a .properties file");
		
		rs=pst.executeQuery();
		while(rs.next())
		{
			Movie tempMovie=new Movie();
			tempMovie.setId(rs.getLong("ID_PELICULA"));
			tempMovie.setName(rs.getString("NOMBRE"));
			tempMovie.setSynopsis(rs.getString("SINOPSIS"));
			tempMovie.setImgPath(rs.getString("RUTA_IMAGEN_CARTEL"));
			tempMovie.setMorningPrice(rs.getDouble("PRECIO_MATUTINO"));
			tempMovie.setDailyPrice(rs.getDouble("PRECIO_DIARIO"));
			tempMovie.setNightPrice(rs.getDouble("PRECIO_NOCHE"));
			
			result.add(tempMovie);
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.MovieDAO#save(com.entrecine4.model.Movie)
	 */
	@Override
	public void save(Movie movie) throws SQLException 
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setString(1, movie.getName());
		pst.setString(2, movie.getSynopsis());
		pst.setString(3, movie.getImgPath());
		pst.setDouble(4, movie.getMorningPrice());
		pst.setDouble(5, movie.getDailyPrice());
		pst.setDouble(6, movie.getNightPrice());
		
		pst.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.MovieDAO#update(com.entrecine4.model.Movie)
	 */
	@Override
	public void update(Movie movie) throws SQLException 
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setString(1, movie.getName());
		pst.setString(2, movie.getSynopsis());
		pst.setString(3, movie.getImgPath());
		pst.setDouble(4, movie.getMorningPrice());
		pst.setDouble(5, movie.getDailyPrice());
		pst.setDouble(6, movie.getNightPrice());
		pst.setLong(7, movie.getId());
		
		pst.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.MovieDAO#delete(com.entrecine4.model.Movie)
	 */
	@Override
	public void delete(Movie movie) throws SQLException
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, movie.getId());
		
		pst.executeUpdate();
	}
}