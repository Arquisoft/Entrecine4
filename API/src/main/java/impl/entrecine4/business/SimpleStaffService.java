package impl.entrecine4.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.entrecine4.infraestructure.Jdbc;
import models.Employee;

import impl.entrecine4.persistence.SimplePersistenceFactory;

import com.entrecine4.business.StaffService;
import com.entrecine4.persistence.EmployeeDAO;

public class SimpleStaffService implements StaffService {

	EmployeeDAO dao = new SimplePersistenceFactory().createEmployeeDAO();

	/* (non-Javadoc)
	 * @see com.entrecine4.business.StaffService#getStaff()
	 */
	@Override
	public List<Employee> getStaff() {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            return dao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.StaffService#findById(java.lang.Long)
	 */
	@Override
	public Employee findById(Long id) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            return dao.get(id);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.StaffService#saveEmployee(com.entrecine4.model.Employee)
	 */
	@Override
	public void saveEmployee(Employee employee) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.save(employee);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.StaffService#updateEmployee(com.entrecine4.model.Employee)
	 */
	@Override
	public void updateEmployee(Employee employee) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.update(employee);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.StaffService#deleteEmployee(com.entrecine4.model.Employee)
	 */
	@Override
	public void deleteEmployee(Employee employee) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.delete(employee);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

}
