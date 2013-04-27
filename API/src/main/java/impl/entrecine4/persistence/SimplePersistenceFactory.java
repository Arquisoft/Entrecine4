package impl.entrecine4.persistence;

import com.entrecine4.persistence.EmployeeDAO;
import com.entrecine4.persistence.IncidenceDAO;
import com.entrecine4.persistence.MovieDAO;
import com.entrecine4.persistence.PersistenceFactory;
import com.entrecine4.persistence.PurchaseDAO;
import com.entrecine4.persistence.RoomDAO;
import com.entrecine4.persistence.SessionDAO;
import com.entrecine4.persistence.SessionStateDAO;
import com.entrecine4.persistence.UserDAO;

public class SimplePersistenceFactory implements PersistenceFactory 
{

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.PersistenceFactory#createEmployeeDAO()
	 */
	@Override
	public EmployeeDAO createEmployeeDAO() 
	{
		return new EmployeeJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.PersistenceFactory#createIncidenceDAO()
	 */
	@Override
	public IncidenceDAO createIncidenceDAO() 
	{
		return new IncidenceJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.PersistenceFactory#createMovieDAO()
	 */
	@Override
	public MovieDAO createMovieDAO() 
	{
		return new MovieJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.PersistenceFactory#createPurchaseDAO()
	 */
	@Override
	public PurchaseDAO createPurchaseDAO() 
	{
		return new PurchaseJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.PersistenceFactory#createRoomDAO()
	 */
	@Override
	public RoomDAO createRoomDAO() 
	{
		return new RoomJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.PersistenceFactory#createSessionDAO()
	 */
	@Override
	public SessionDAO createSessionDAO() 
	{
		return new SessionJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.PersistenceFactory#createSessionStateDAO()
	 */
	@Override
	public SessionStateDAO createSessionStateDAO() 
	{
		return new SessionStateJdbcDAO();
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.PersistenceFactory#createUserDAO()
	 */
	@Override
	public UserDAO createUserDAO() 
	{
		return new UserJdbcDAO();
	}
}