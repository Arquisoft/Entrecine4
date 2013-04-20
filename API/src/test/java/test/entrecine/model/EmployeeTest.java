package test.entrecine.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.entrecine4.model.Employee;;

public class EmployeeTest {
	
	private Employee emp1, emp2;
	
	private final static long ID = 1;
	private final static String USERNAME = "root";
	private final static String PASSWORD = "123456";
	private final static int ISADMIN1 = 0, ISADMIN2 = 1;
	
	/**
	 * Test without parameters, this will test setters
	 */
	@Test
	public void testWithoutParameters() {
		emp1 = new Employee();
		emp1.setId(ID);
		emp1.setUsername(USERNAME);
		emp1.setPassword(PASSWORD);
		emp1.setIsAdmin(ISADMIN1);
		testAttributes(emp1, 1);
	}
	
	/**
	 * Test with parameters, this will test getters and constructor with parameters
	 */
	@Test
	public void testWithParameters() {
		emp2 = new Employee(ID, USERNAME, PASSWORD, ISADMIN2);
		testAttributes(emp2, 2);
	}

	/**
	 * Method for test the attributes
	 * @param the employee to test
	 */
	private void testAttributes(Employee emp, int num) {
		assertEquals(emp.getId(), ID);
		assertEquals(emp.getUsername(), USERNAME);
		assertEquals(emp.getPassword(), PASSWORD);
		if(num == 1)
			assertEquals(emp.getIsAdmin(), ISADMIN1);
		else
			assertEquals(emp.getIsAdmin(), ISADMIN2);

	}

	
}
