package test.entrecine.persistence;

import static org.junit.Assert.*;
import impl.entrecine4.persistence.EmployeeJdbcDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.model.Employee;
import com.entrecine4.persistence.EmployeeDAO;

public class EmployeeDaoTest {

	private static EmployeeDAO dao = new EmployeeJdbcDAO();
	private static Connection con = Jdbc.getConnection(); // we need the connection here

	/**
	 * Method before all test
	 * 
	 * @throws SQLException
	 */
	@BeforeClass
	public static void setUp() throws SQLException {
		dao.setConnection(con);
		con.setAutoCommit(false);
	}

	/**
	 * Insert two employees with the same username. Expected to fail
	 * 
	 * @throws SQLException
	 */
	@Test(expected = SQLException.class)
	public void testInsertTwo() throws SQLException {
		Employee emp = new Employee(0, "user", "user", 0);
		dao.save(emp);
		dao.save(emp);
	}

	/**
	 * Test of saving and deleting user
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testSaveAndDelete() throws SQLException {
		Employee emp = new Employee(0, "emp01", "emp01", 0);
		dao.save(emp);
		List<Employee> recoveredEmployees = dao.getAll();
		Employee recoveredEmployee = recoveredEmployees.get(recoveredEmployees.size() - 1);
		assertEquals(emp.getUsername(), recoveredEmployee.getUsername());
		assertEquals(emp.getPassword(), recoveredEmployee.getPassword());
		dao.delete(emp);
		assertEquals(dao.get(1), null);
	}

	/**
	 * Test with a non existing id
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetBadId() throws SQLException {
		Employee emp = dao.get(-1);
		assertEquals(emp, null);
	}

	/**
	 * Update test for a user
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testUpdate() throws SQLException {
		Employee emp = new Employee(0, "emp02", "emp02", 0);
		dao.save(emp);
		emp.setPassword("emp02mod");
		dao.update(emp);
		List<Employee> recoveredEmployees = dao.getAll();
		Employee recoveredEmployee = recoveredEmployees.get(recoveredEmployees.size() - 1 );
		assertEquals(recoveredEmployee.getPassword(), "emp02mod");
	}

	/**
	 * Method after all tests
	 * 
	 * @throws SQLException
	 */
	@AfterClass
	public static void setDown() throws SQLException {
		con.rollback();
		con.close();
	}

}
