package impl.entrecine4.infraestructure;

import impl.entrecine4.persistence.SimplePersistenceFactory;

import java.sql.SQLException;
import java.util.List;

import com.entrecine4.infraestructure.UserService;
import com.entrecine4.model.User;
import com.entrecine4.persistence.UserDAO;

public class SimpleUserService implements UserService {

	private UserDAO dao = new SimplePersistenceFactory().createUserDAO();

	@Override
	public User get(long id) throws RuntimeException {
		try {
			return dao.get(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User get(String username) throws RuntimeException {
		try {
			return dao.get(username);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> getAll() throws RuntimeException {
		try {
			return dao.getAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(User user) throws RuntimeException {
		try {
			dao.save(user);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(User user) throws RuntimeException {
		try {
			dao.update(user);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(User user) throws RuntimeException {
		try {
			dao.delete(user);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
