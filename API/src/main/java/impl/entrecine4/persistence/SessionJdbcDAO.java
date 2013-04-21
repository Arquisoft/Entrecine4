package impl.entrecine4.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entrecine4.model.Room;
import com.entrecine4.model.Session;
import com.entrecine4.persistence.SessionDAO;

//TODO:No JUnit yet
public class SessionJdbcDAO implements SessionDAO
{
	//Variables to use in the class and this way don't be defining all the time the same variables in each method
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
		
	@Override
	public Session get(String movieTitle, Date day, double time, Room room) throws SQLException 
	{
		//TODO:Alternatives: Use an id, overload the method a search with [day,time,room]/[movieTitle/day/time]/[movieTitle,time]...
		Session result=null;
		
		pst=connection.prepareStatement("SQL using a .properties file");
		
		return result;
	}

	@Override
	public List<Session> getAll() throws SQLException 
	{
		List<Session> result=new ArrayList<Session>();
		
		pst=connection.prepareStatement("SQL using a .properties file");
		
		rs=pst.executeQuery();
		while(rs.next())
		{
			Session tempSession = new Session();
			tempSession.setMovieTitle(rs.getString("NOMBRE_PELICULA"));
			tempSession.setDay(rs.getDate("DIA"));
			tempSession.setTime(rs.getDouble("HORA"));
			//TODO:How are we going to save the room??tempSession.setRoom()
			
			result.add(tempSession);
		}
		
		return result;
	}

	@Override
	public void save(Session session) throws SQLException 
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setString(1,session.getMovieTitle());
		pst.setDate(2,(java.sql.Date) session.getDay());
		pst.setDouble(3, session.getTime());
		//TODO: Again how to save the room
		
		pst.executeUpdate();
	}

	@Override
	public void update(Session session) throws SQLException 
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setString(1,session.getMovieTitle());
		pst.setDate(2,(java.sql.Date) session.getDay());
		pst.setDouble(3, session.getTime());
		//TODO: Again how to save the room and how to select the session to update
		
		pst.executeUpdate();
	}

	@Override
	public void delete(Session session) throws SQLException 
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		//TODO: how to select the session to delete
		
		pst.executeUpdate();
	}
}
