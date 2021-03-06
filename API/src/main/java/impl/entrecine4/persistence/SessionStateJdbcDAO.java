package impl.entrecine4.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.SessionState;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.infraestructure.PropertiesReader;
import com.entrecine4.persistence.SessionStateDAO;

/**
 * Implementation for session's state dao interface
 * @author Arquisoft - Entrecine4
 *
 */
public class SessionStateJdbcDAO implements SessionStateDAO {
	
	private final static String GET_SESSIONSTATE = PropertiesReader.get("GET_SESSIONSTATE");
	private final static String GET_SESSIONSTATE_BY_ID_DATE_SESSION = PropertiesReader.get("GET_SESSIONSTATE_BY_ID_DATE_SESSION");
	private final static String GET_SESSIONSTATE_BY_SESSION = PropertiesReader.get("GET_SESSIONSTATE_BY_SESSION");
	private final static String GET_ALL_SESSIONSTATE = PropertiesReader.get("GET_ALL_SESSIONSTATE");
	private final static String INSERT_SESSIONSTATE = PropertiesReader.get("INSERT_SESSIONSTATE");
	private final static String UPDATE_SESSIONSTATE = PropertiesReader.get("UPDATE_SESSIONSTATE");
	private final static String DELETE_SESSIONSTATE = PropertiesReader.get("DELETE_SESSIONSTATE");
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public void setConnection(Connection con) {
		this.con = con;
		PropertiesReader.setFile("sql.properties");
	}

	@Override
	public SessionState get(SessionState ss) throws SQLException {
		SessionState sessionState = null;
		ps = con.prepareStatement(GET_SESSIONSTATE);
		ps.setLong(1, ss.getRoomId());
		ps.setInt(2, ss.getRow());
		ps.setInt(3, ss.getColumn());
		ps.setDate(4, new java.sql.Date(ss.getDate().getTime()));
		ps.setLong(5, ss.getSession());
		rs = ps.executeQuery();
		if(rs.next())
			sessionState = new SessionState(rs.getLong("ID_SALA"), rs.getInt("FILA_OCUPADA"),
					rs.getInt("COLUMNA_OCUPADA"), rs.getDate("DIA"), rs.getLong("SESION"));
		Jdbc.close(rs, ps);
		return sessionState;
	}

	@Override
	public List<SessionState> get(long roomId, Date date, long session)
			throws SQLException {
		List<SessionState> sessionStates = new ArrayList<SessionState>();
		ps = con.prepareStatement(GET_SESSIONSTATE_BY_ID_DATE_SESSION);
		ps.setLong(1, roomId);
		ps.setDate(4, new java.sql.Date(date.getTime()));
		ps.setLong(5, session);
		rs = ps.executeQuery();
		while(rs.next())
			sessionStates.add(new SessionState(rs.getLong("ID_SALA"), rs.getInt("FILA_OCUPADA"),
					rs.getInt("COLUMNA_OCUPADA"), rs.getDate("DIA"), rs.getLong("SESION")));
		Jdbc.close(rs, ps);
		return sessionStates;
	}
	

	@Override
	public List<SessionState> getBySession(long sessionId) throws SQLException 
	{	
		List<SessionState> sessionStates = new ArrayList<SessionState>();
		
		ps = con.prepareStatement(GET_SESSIONSTATE_BY_SESSION);
		ps.setLong(1, sessionId);
		
		rs = ps.executeQuery();
		while(rs.next())
			sessionStates.add(new SessionState(rs.getLong("ID_SALA"), rs.getInt("FILA_OCUPADA"),
					rs.getInt("COLUMNA_OCUPADA"), rs.getDate("DIA"), rs.getLong("SESION")));
		
		Jdbc.close(rs, ps);
		
		return sessionStates;
	}

	@Override
	public List<SessionState> getAll() throws SQLException 
	{
		List<SessionState> sessionStates = new ArrayList<SessionState>();
		
		ps = con.prepareStatement(GET_ALL_SESSIONSTATE);
		
		rs = ps.executeQuery();
		while(rs.next())
			sessionStates.add(new SessionState(rs.getLong("ID_SALA"), rs.getInt("FILA_OCUPADA"),
					rs.getInt("COLUMNA_OCUPADA"), rs.getDate("DIA"), rs.getLong("SESION")));
		
		Jdbc.close(rs, ps);
		
		return sessionStates;
	}

	@Override
	public void save(SessionState ss) throws SQLException {
		ps = con.prepareStatement(INSERT_SESSIONSTATE);
		ps.setLong(1, ss.getRoomId());
		ps.setInt(2, ss.getRow());
		ps.setInt(3, ss.getColumn());
		ps.setDate(4, new java.sql.Date(ss.getDate().getTime()));
		ps.setLong(5, ss.getSession());
		ps.executeUpdate();
		Jdbc.close(ps);
	}

	@Override
	public void update(SessionState ss) throws SQLException {
		ps = con.prepareStatement(UPDATE_SESSIONSTATE);
		ps.setInt(1, ss.getRow());
		ps.setInt(2, ss.getColumn());
		ps.setLong(3, ss.getRoomId());
		ps.setDate(4, new java.sql.Date(ss.getDate().getTime()));
		ps.setLong(5, ss.getSession());
		ps.executeUpdate();
		Jdbc.close(ps);
	}

	@Override
	public void delete(SessionState ss) throws SQLException {
		ps = con.prepareStatement(DELETE_SESSIONSTATE);
		ps.setLong(1, ss.getRoomId());
		ps.setInt(2, ss.getRow());
		ps.setInt(3, ss.getColumn());
		ps.setDate(4, new java.sql.Date(ss.getDate().getTime()));
		ps.setLong(5, ss.getSession());
		ps.executeUpdate();
		Jdbc.close(ps);
	}
}