package impl.entrecine4.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entrecine4.model.Employee;
import com.entrecine4.persistence.EmployeeDAO;

public class EmployeeJdbcDAO implements EmployeeDAO {

	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.entrecine4.persistence.EmployeeDAO#get(long)
	 */
	@Override
	public Employee get(long employeeID) throws SQLException {
		Employee result = null;

		pst = connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, employeeID);

		rs = pst.executeQuery();
		if (rs.next()) {
			result = new Employee();
			result.setId(employeeID);
			result.setUsername(rs.getString("USERNAME"));
			result.setPassword(rs.getString("PASSWORD"));
			result.setIsAdmin(rs.getInt("ISADMIN"));
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.entrecine4.persistence.EmployeeDAO#getAll()
	 */
	@Override
	public List<Employee> getAll() throws SQLException {
		List<Employee> result = new ArrayList<Employee>();

		pst = connection.prepareStatement("SQL using a .properties file");

		rs = pst.executeQuery();

		while (rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getLong("ID_USUARIO"));
			emp.setUsername(rs.getString("USERNAME"));
			emp.setPassword(rs.getString("PASSWORD"));
			emp.setIsAdmin(rs.getInt("ISADMIN"));

			// Finally we add the temporal employee to the list that will be
			// returned.
			result.add(emp);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.entrecine4.persistence.EmployeeDAO#save(com.entrecine4.model.Employee
	 * )
	 */
	@Override
	public void save(Employee employee) throws SQLException {
		pst = connection.prepareStatement("SQL using a .properties file");

		pst.setString(1, employee.getUsername());
		pst.setString(2, employee.getPassword());
		pst.setInt(3, employee.getIsAdmin());

		pst.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.entrecine4.persistence.EmployeeDAO#update(com.entrecine4.model.Employee
	 * )
	 */
	@Override
	public void update(Employee employee) throws SQLException {
		pst = connection.prepareStatement("SQL using a .properties file");

		pst.setString(1, employee.getUsername());
		pst.setString(2, employee.getPassword());
		pst.setInt(3, employee.getIsAdmin());
		pst.setLong(4, employee.getId()); // ID of the user that will be updated

		pst.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.entrecine4.persistence.EmployeeDAO#delete(com.entrecine4.model.Employee
	 * )
	 */
	@Override
	public void delete(Employee employee) throws SQLException {
		pst = connection.prepareStatement("SQL using a .properties file");
		pst.setLong(1, employee.getId());

		pst.executeUpdate();

	}

	/*
	 * (non-Javadoc)
	 * @see com.entrecine4.persistence.EmployeeDAO#setConnection(java.sql.Connection)
	 */
	@Override
	public void setConnection(Connection con) {
		this.connection = con;
		
	}

}
