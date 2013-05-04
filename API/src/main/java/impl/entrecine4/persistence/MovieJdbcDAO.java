package impl.entrecine4.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Movie;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.infraestructure.PropertiesReader;
import com.entrecine4.persistence.MovieDAO;

public class MovieJdbcDAO implements MovieDAO
{
	//Variables to use in the class and this way don't be defining all the time the same variables in each method
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.MovieDAO#setConnection(java.sql.Connection)
	 */
	@Override
	public void setConnection(Connection connection)
	{
		this.connection=connection;
		PropertiesReader.setFile("sql.properties");
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.MovieDAO#get(long)
	 */
	@Override
	public Movie get(long movieId) throws SQLException 
	{
		Movie result=null;
		
		pst=connection.prepareStatement(PropertiesReader.get("GET_MOVIE_BY_ID"));
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
			result.setDailyPrice(rs.getDouble("PRECIO_TARDE"));
			result.setNightPrice(rs.getDouble("PRECIO_NOCHE"));
			result.setGenre(rs.getString("GENERO"));
		}
		
		Jdbc.close(rs, pst);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.MovieDAO#get(java.lang.String)
	 */
	@Override
	public Movie get(String movieName) throws SQLException 
	{
		Movie result=null;
		
		pst=connection.prepareStatement(PropertiesReader.get("GET_MOVIE_BY_NAME"));
		pst.setString(1, movieName);
		
		rs=pst.executeQuery();
		if(rs.next())
		{
			result=new Movie();
			result.setId(rs.getLong("ID_PELICULA"));
			result.setName(movieName);
			result.setSynopsis(rs.getString("SINOPSIS"));
			result.setImgPath(rs.getString("RUTA_IMAGEN_CARTEL"));
			result.setMorningPrice(rs.getDouble("PRECIO_MATUTINO"));
			result.setDailyPrice(rs.getDouble("PRECIO_TARDE"));
			result.setNightPrice(rs.getDouble("PRECIO_NOCHE"));
			result.setGenre(rs.getString("GENERO"));
		}
		
		Jdbc.close(rs, pst);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.MovieDAO#getAll()
	 */
	@Override
	public List<Movie> getAll() throws SQLException 
	{
		List<Movie> result=new ArrayList<Movie>();
		
		pst=connection.prepareStatement(PropertiesReader.get("GET_ALL_MOVIES"));
		
		rs=pst.executeQuery();
		while(rs.next())
		{
			Movie tempMovie=new Movie();
			tempMovie.setId(rs.getLong("ID_PELICULA"));
			tempMovie.setName(rs.getString("NOMBRE"));
			tempMovie.setSynopsis(rs.getString("SINOPSIS"));
			tempMovie.setImgPath(rs.getString("RUTA_IMAGEN_CARTEL"));
			tempMovie.setMorningPrice(rs.getDouble("PRECIO_MATUTINO"));
			tempMovie.setDailyPrice(rs.getDouble("PRECIO_TARDE"));
			tempMovie.setNightPrice(rs.getDouble("PRECIO_NOCHE"));
			tempMovie.setGenre(rs.getString("GENERO"));
			
			result.add(tempMovie);
		}
		
		Jdbc.close(rs, pst);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.MovieDAO#save(com.entrecine4.model.Movie)
	 */
	@Override
	public void save(Movie movie) throws SQLException 
	{
		pst=connection.prepareStatement(PropertiesReader.get("INSERT_MOVIE"));
		pst.setString(1, movie.getName());
		pst.setString(2, movie.getSynopsis());
		pst.setString(3, movie.getImgPath());
		pst.setDouble(4, movie.getMorningPrice());
		pst.setDouble(5, movie.getDailyPrice());
		pst.setDouble(6, movie.getNightPrice());
		pst.setString(7, movie.getGenre());
		
		pst.executeUpdate();
		Jdbc.close(pst);
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.MovieDAO#update(com.entrecine4.model.Movie)
	 */
	@Override
	public void update(Movie movie) throws SQLException 
	{
		pst=connection.prepareStatement(PropertiesReader.get("UPDATE_MOVIE"));
		pst.setString(1, movie.getName());
		pst.setString(2, movie.getSynopsis());
		pst.setString(3, movie.getImgPath());
		pst.setDouble(4, movie.getMorningPrice());
		pst.setDouble(5, movie.getDailyPrice());
		pst.setDouble(6, movie.getNightPrice());
		pst.setString(7, movie.getGenre());
		pst.setLong(8, movie.getId());
		
		pst.executeUpdate();
		Jdbc.close(pst);
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.MovieDAO#delete(com.entrecine4.model.Movie)
	 */
	@Override
	public void delete(Movie movie) throws SQLException
	{
		pst=connection.prepareStatement(PropertiesReader.get("DELETE_MOVIE"));
		pst.setLong(1, movie.getId());
		
		pst.executeUpdate();
		Jdbc.close(pst);
	}
}