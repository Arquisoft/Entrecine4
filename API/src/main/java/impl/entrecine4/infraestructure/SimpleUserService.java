package impl.entrecine4.infraestructure;

import com.entrecine4.infraestructure.Jdbc;
import impl.entrecine4.persistence.SimplePersistenceFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.User;

import com.entrecine4.infraestructure.UserService;
import com.entrecine4.persistence.UserDAO;

public class SimpleUserService implements UserService {

	private UserDAO dao = new SimplePersistenceFactory().createUserDAO();

	/* (non-Javadoc)
	 * @see com.entrecine4.infraestructure.UserService#get(long)
	 */
	@Override
	public User get(long id) throws RuntimeException {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
			return dao.get(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
            Jdbc.close(con);
        }
    }

	/* (non-Javadoc)
	 * @see com.entrecine4.infraestructure.UserService#get(java.lang.String)
	 */
	@Override
	public User get(String username) throws RuntimeException {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            return dao.get(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.infraestructure.UserService#getAll()
	 */
	@Override
	public List<User> getAll() throws RuntimeException {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            return dao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.infraestructure.UserService#save(com.entrecine4.model.User)
	 */
	@Override
	public void save(User user) throws RuntimeException {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.save(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Jdbc.close(con);
        }
    }

	/* (non-Javadoc)
	 * @see com.entrecine4.infraestructure.UserService#update(com.entrecine4.model.User)
	 */
	@Override
	public void update(User user) throws RuntimeException {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.update(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.infraestructure.UserService#delete(com.entrecine4.model.User)
	 */
	@Override
	public void delete(User user) throws RuntimeException {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.delete(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.infraestructure.UserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String username, String password) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            User user = dao.get(username);
            if(user==null)
                return null;
            else if(!user.getPassword().equals(password))
                return null;
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Jdbc.close(con);
        }
	}

}