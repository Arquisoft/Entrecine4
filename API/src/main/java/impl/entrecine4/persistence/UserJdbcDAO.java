package impl.entrecine4.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.model.User;
import com.entrecine4.persistence.UserDAO;

/**
 * Implementation for user's dao interface
 * @author Arquisoft - Entrecine4
 *
 */
public class UserJdbcDAO implements UserDAO {
	
	private final static String GET_USER_BY_ID = "select * from DATOS_USUARIOS_WEB where ID_USUARIO = ?";
	private final static String GET_USER_BY_USERNAME = "select * from DATOS_USUARIOS_WEB where USERNAME = ?";
	private final static String GET_ALL_USERS = "select * from DATOS_USUARIOS_WEB";
	private final static String INSERT_USER = "insert into DATOS_USUARIOS_WEB (USERNAME, PASSWORD) values (?, ?)";
	private final static String DELETE_USER = "delete from DATOS_USUARIOS_WEB where ID_USUARIO = ?";
	private final static String UPDATE_USER = "update DATOS_USUARIOS_WEB set USERNAME=?, PASSWORD=? where ID_USUARIO = ?";
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.UserDAO#setConnection(java.sql.Connection)
	 */
	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.UserDAO#get(long)
	 */
	@Override
	public User get(long id) throws SQLException {
		User user = null;
		ps = con.prepareStatement(GET_USER_BY_ID);
		ps.setLong(1, id);
		rs = ps.executeQuery();
		if(rs.next())
			user = new User(rs.getLong("ID_USUARIO"), rs.getString("USERNAME"),
					rs.getString("PASSWORD"));
		Jdbc.close(rs, ps);
		return user;
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.UserDAO#get(java.lang.String)
	 */
	@Override
	public User get(String username) throws SQLException {
		User user = null;
		ps = con.prepareStatement(GET_USER_BY_USERNAME);
		ps.setString(1, username);
		rs = ps.executeQuery();
		if(rs.next())
			user = new User(rs.getLong("ID_USUARIO"), rs.getString("USERNAME"),
					rs.getString("PASSWORD"));
		Jdbc.close(rs, ps);
		return user;
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.UserDAO#getAll()
	 */
	@Override
	public List<User> getAll() throws SQLException {
		List<User> users = new ArrayList<User>();
		ps = con.prepareStatement(GET_ALL_USERS);
		rs = ps.executeQuery();
		while(rs.next())
			users.add(new User(rs.getLong("ID_USUARIO"), rs.getString("USERNAME"),
					rs.getString("PASSWORD")));
		Jdbc.close(rs, ps);
		return users;
	}
	
	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.UserDAO#save(com.entrecine4.model.User)
	 */
	@Override
	public void save(User user) throws SQLException {
		ps = con.prepareStatement(INSERT_USER);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.executeUpdate();
		Jdbc.close(ps);
	}
	
	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.UserDAO#update(com.entrecine4.model.User)
	 */
	@Override
	public void update(User user) throws SQLException {
		ps = con.prepareStatement(UPDATE_USER);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setLong(3, user.getId());
		ps.executeUpdate();
		Jdbc.close(ps);
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.persistence.UserDAO#delete(com.entrecine4.model.User)
	 */
	@Override
	public void delete(User user) throws SQLException {
		ps = con.prepareStatement(DELETE_USER);
		ps.setLong(1, user.getId());
		ps.executeUpdate();
		Jdbc.close(ps);
	}


}
