package impl.entrecine4.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import models.Session;

import com.entrecine4.business.SessionService;
import com.entrecine4.infraestructure.Factories;
import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.persistence.SessionDAO;

public class SimpleSessionService implements SessionService 
{
	private SessionDAO dao=Factories.persistence.createSessionDAO();
	
	/* (non-Javadoc)
	 * @see com.entrecine4.business.SessionService#getSessions()
	 */
	@Override
	public List<Session> getSessions() 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			return dao.getAll();
		} catch (SQLException e) 
		{
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.SessionService#findById(long)
	 */
	@Override
	public Session findById(long id)
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			return dao.get(id);
		} catch (SQLException e) 
		{
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.SessionService#findByMovie(java.lang.String)
	 */
	@Override
	public List<Session> findByMovie(String movieTitle) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			return dao.getByMovie(movieTitle);
		} catch (SQLException e) 
		{
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.SessionService#findByDay(java.util.Date)
	 */
	@Override
	public List<Session> findByDay(Date day) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			return dao.getByDay(day);
		} catch (SQLException e) 
		{
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.SessionService#findByDayAndTime(java.util.Date, double)
	 */
	@Override
	public List<Session> findByDayAndTime(Date day, double time) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			return dao.getByDayAndTime(day, time);
		} catch (SQLException e) 
		{
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.SessionService#saveSession(models.Session)
	 */
	@Override
	public void saveSession(Session session) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			dao.save(session);
		} catch (SQLException e) 
		{
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.SessionService#updateSession(models.Session)
	 */
	@Override
	public void updateSession(Session session) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			dao.update(session);
		} catch (SQLException e) 
		{
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.SessionService#deleteSession(models.Session)
	 */
	@Override
	public void deleteSession(Session session)
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			dao.delete(session);
		} catch (SQLException e) 
		{
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}
}