package impl.entrecine4.business;

import java.sql.SQLException;
import java.util.List;

import impl.entrecine4.persistence.SimplePersistenceFactory;

import com.entrecine4.business.StaffService;
import com.entrecine4.model.Employee;
import com.entrecine4.persistence.EmployeeDAO;

public class SimpleStaffService implements StaffService {

	EmployeeDAO dao = new SimplePersistenceFactory().createEmployeeDAO();

	@Override
	public List<Employee> getStaff() {
		try {
			return dao.getAll();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public Employee findById(Long id) {
		try {
			return dao.get(id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void saveEmployee(Employee employee) {
		try {
			dao.save(employee);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		try {
			dao.update(employee);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void deleteEmployee(Employee employee) {
		try {
			dao.delete(employee);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
