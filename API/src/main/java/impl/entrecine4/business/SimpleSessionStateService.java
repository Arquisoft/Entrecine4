package impl.entrecine4.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import models.SessionState;

import com.entrecine4.business.SessionStateService;
import com.entrecine4.infraestructure.Factories;
import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.persistence.SessionDAO;
import com.entrecine4.persistence.SessionStateDAO;

public class SimpleSessionStateService implements SessionStateService 
{
	private SessionStateDAO dao= Factories.persistence.createSessionStateDAO();
	
	/* (non-Javadoc)
	 * @see com.entrecine4.business.SessionStateService#getSessionStates()
	 */
	@Override
	public List<SessionState> getSessionStates() 
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
	 * @see com.entrecine4.business.SessionStateService#findBySession(long)
	 */
	@Override
	public List<SessionState> findBySession(long sessionId) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			return dao.getBySession(sessionId);
		} catch (SQLException e) 
		{
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.SessionStateService#checkFreeSeat(long, long, int, int)
	 */
	@Override
	public boolean checkFreeSeat(long session, long room, int row, int column) 
	{
		Connection con = Jdbc.getConnection();
		Date temp;
		try {
			//Get an auxiliar dao to get the date of the session
			SessionDAO sdao=Factories.persistence.createSessionDAO();
			sdao.setConnection(con);
			dao.setConnection(con);
			
			temp = sdao.get(session).getDay();
			SessionState st=new SessionState(room, row, column, temp,session);
			
			return (dao.get(st)==null) ? true : false;
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.SessionStateService#saveSessionState(models.SessionState)
	 */
	@Override
	public void saveSessionState(SessionState sessionState) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			dao.save(sessionState);
		} catch (SQLException e) 
		{
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.SessionStateService#updateSessionState(models.SessionState)
	 */
	@Override
	public void updateSessionState(SessionState sessionState) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			dao.update(sessionState);
		} catch (SQLException e) 
		{
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.SessionStateService#deleteSessionState(models.SessionState)
	 */
	@Override
	public void deleteSessionState(SessionState sessionState) 
	{
		Connection con = Jdbc.getConnection();
		try {
			dao.setConnection(con);
			dao.delete(sessionState);
		} catch (SQLException e) 
		{
			throw new RuntimeException();
		} finally
		{
			Jdbc.close(con);
		}
	}
}