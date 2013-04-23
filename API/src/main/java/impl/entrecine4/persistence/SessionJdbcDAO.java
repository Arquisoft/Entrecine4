package impl.entrecine4.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entrecine4.model.Session;
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
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.SessionDAO#get(long)
	 */
	@Override
	public Session get(long sessionId) throws SQLException 
	{
		Session result=null;
		
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, sessionId);
		
		rs=pst.executeQuery();
		if(rs.next())
		{
			result=new Session();
			result.setId(sessionId);
			result.setMovieTitle(rs.getString("NOMBRE_PELICULA"));
			result.setDay(rs.getDate("DIA"));
			result.setTime(rs.getDouble("HORA"));
			result.setRoomId(rs.getLong("SALA"));
		}
		
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
			tempSession.setId(rs.getLong("ID"));
			tempSession.setMovieTitle(rs.getString("NOMBRE_PELICULA"));
			tempSession.setDay(rs.getDate("DIA"));
			tempSession.setTime(rs.getDouble("HORA"));
			tempSession.setRoomId(rs.getLong("SALA"));
			
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
		pst.setLong(4, session.getRoomId());
		
		pst.executeUpdate();
	}

	@Override
	public void update(Session session) throws SQLException 
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setString(1,session.getMovieTitle());
		pst.setDate(2,(java.sql.Date) session.getDay());
		pst.setDouble(3, session.getTime());
		pst.setLong(4, session.getRoomId());
		pst.setLong(5, session.getId());
		
		pst.executeUpdate();
	}

	@Override
	public void delete(Session session) throws SQLException 
	{
		pst=connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, session.getId());
		
		pst.executeUpdate();
	}
}
