package impl.entrecine4.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Session;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.infraestructure.PropertiesReader;
import com.entrecine4.persistence.SessionDAO;

public class SessionJdbcDAO implements SessionDAO
{
	//Variables to use in the class and this way don't be defining all the time the same variables in each method
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
		
	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.SessionDAO#setConnection(java.sql.Connection)
	 */
	@Override
	public void setConnection(Connection connection) 
	{
		this.connection=connection;
		PropertiesReader.setFile("sql.properties");
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.SessionDAO#get(long)
	 */
	@Override
	public Session get(long sessionId) throws SQLException 
	{
		Session result=null;
		
		pst=connection.prepareStatement(PropertiesReader.get("GET_SESSION_BY_ID"));
		pst.setLong(1, sessionId);
		
		rs=pst.executeQuery();
		if(rs.next())
		{
			result=new Session();
			result.setId(sessionId);
			result.setMovieTitle(rs.getString("NOMBRE_PELICULA"));
			result.setDay(rs.getDate("DIA"));
			result.setTime(rs.getDouble("SESION"));
			result.setRoomId(rs.getLong("SALA"));
		}
		
		Jdbc.close(rs, pst);
		
		return result;
	}

	@Override
	public List<Session> getAll() throws SQLException 
	{
		List<Session> result=new ArrayList<Session>();
		
		pst=connection.prepareStatement(PropertiesReader.get("GET_ALL_SESSIONS"));
		
		rs=pst.executeQuery();
		while(rs.next())
		{
			Session tempSession = new Session();
			tempSession.setId(rs.getLong("ID"));
			tempSession.setMovieTitle(rs.getString("NOMBRE_PELICULA"));
			tempSession.setDay(rs.getDate("DIA"));
			tempSession.setTime(rs.getDouble("SESION"));
			tempSession.setRoomId(rs.getLong("SALA"));
			
			result.add(tempSession);
		}
		
		Jdbc.close(rs, pst);
		
		return result;
	}
	
	@Override
	public List<Session> getByMovie(String movieTitle) throws SQLException 
	{
		List<Session> result=new ArrayList<Session>();
		
		pst=connection.prepareStatement(PropertiesReader.get("GET_SESSIONS_BY_MOVIE"));
		pst.setString(1, movieTitle);
		
		rs=pst.executeQuery();
		while(rs.next())
		{
			Session tempSession = new Session();
			tempSession.setId(rs.getLong("ID"));
			tempSession.setMovieTitle(rs.getString("NOMBRE_PELICULA"));
			tempSession.setDay(rs.getDate("DIA"));
			tempSession.setTime(rs.getDouble("SESION"));
			tempSession.setRoomId(rs.getLong("SALA"));
			
			result.add(tempSession);
		}
		
		Jdbc.close(rs, pst);
		
		return result;
	}

	@Override
	public List<Session> getByDay(Date day) throws SQLException 
	{
		List<Session> result=new ArrayList<Session>();
		
		pst=connection.prepareStatement(PropertiesReader.get("GET_SESSIONS_BY_DAY"));
		pst.setDate(1, new java.sql.Date(day.getTime()));
		
		rs=pst.executeQuery();
		while(rs.next())
		{
			Session tempSession = new Session();
			tempSession.setId(rs.getLong("ID"));
			tempSession.setMovieTitle(rs.getString("NOMBRE_PELICULA"));
			tempSession.setDay(rs.getDate("DIA"));
			tempSession.setTime(rs.getDouble("SESION"));
			tempSession.setRoomId(rs.getLong("SALA"));
			
			result.add(tempSession);
		}
		
		Jdbc.close(rs, pst);
		
		return result;
	}

	@Override
	public List<Session> getByDayAndTime(Date day, double time) throws SQLException 
	{
		List<Session> result=new ArrayList<Session>();
		
		pst=connection.prepareStatement(PropertiesReader.get("GET_SESSIONS_BY_DAY_AND_TIME"));
		pst.setDate(1, new java.sql.Date(day.getTime()));
		pst.setDouble(2, time);
		
		rs=pst.executeQuery();
		while(rs.next())
		{
			Session tempSession = new Session();
			tempSession.setId(rs.getLong("ID"));
			tempSession.setMovieTitle(rs.getString("NOMBRE_PELICULA"));
			tempSession.setDay(rs.getDate("DIA"));
			tempSession.setTime(rs.getDouble("SESION"));
			tempSession.setRoomId(rs.getLong("SALA"));
			
			result.add(tempSession);
		}
		
		Jdbc.close(rs, pst);
		
		return result;
	}

    @Override
    public List<Session> getByDayTimeAndFilmName(Date date, double session, String filmName) throws SQLException {
        List<Session> result=new ArrayList<Session>();

        pst=connection.prepareStatement(PropertiesReader.get("GET_SESSIONS_BY_DAY_TIME_AND_FILMNAME"));
        pst.setDate(1, new java.sql.Date(date.getTime()));
        pst.setDouble(2, session);
        pst.setString(3, filmName);

        rs=pst.executeQuery();
        while(rs.next()) {
            Session tempSession = new Session();
            tempSession.setId(rs.getLong("ID"));
            tempSession.setMovieTitle(rs.getString("NOMBRE_PELICULA"));
            tempSession.setDay(rs.getDate("DIA"));
            tempSession.setTime(rs.getDouble("SESION"));
            tempSession.setRoomId(rs.getLong("SALA"));

            result.add(tempSession);
        }

        Jdbc.close(rs, pst);

        return result;
    }

    @Override
	public void save(Session session) throws SQLException 
	{
		pst=connection.prepareStatement(PropertiesReader.get("INSERT_SESSION"));
		pst.setString(1,session.getMovieTitle());
		pst.setDate(2,(java.sql.Date) session.getDay());
		pst.setDouble(3, session.getTime());
		pst.setLong(4, session.getRoomId());
		
		pst.executeUpdate();
		
		Jdbc.close(pst);
	}

	@Override
	public void update(Session session) throws SQLException 
	{
		pst=connection.prepareStatement(PropertiesReader.get("UPDATE_SESSION"));
		pst.setString(1,session.getMovieTitle());
		pst.setDate(2,(java.sql.Date) session.getDay());
		pst.setDouble(3, session.getTime());
		pst.setLong(4, session.getRoomId());
		pst.setLong(5, session.getId());
		
		pst.executeUpdate();
		
		Jdbc.close(pst);
	}

	@Override
	public void delete(Session session) throws SQLException 
	{
		pst=connection.prepareStatement(PropertiesReader.get("DELETE_SESSION"));
		pst.setLong(1, session.getId());
		
		pst.executeUpdate();
		
		Jdbc.close(pst);
	}
}