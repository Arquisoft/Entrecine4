package test.entrecine.model;

import static org.junit.Assert.*;

import models.Employee;

import org.junit.Test;


public class EmployeeTest {
	
	private Employee emp1, emp2;
	
	private final static long ID = 1;
	private final static String USERNAME = "root";
	private final static String PASSWORD = "123456";
	private final static int ISADMIN1 = 0, ISADMIN2 = 1;
	private final static int TPV_PRIVILEGE1=0, TPV_PRIVILEGE2=1;
	
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
		emp1.setTpvPrivilege(TPV_PRIVILEGE1);
		testAttributes(emp1, 1);
	}
	
	/**
	 * Test with parameters, this will test getters and constructor with parameters
	 */
	@Test
	public void testWithParameters() {
		emp2 = new Employee(ID, USERNAME, PASSWORD, ISADMIN2, TPV_PRIVILEGE2);
		testAttributes(emp2, 2);
	}

	/**
	 * Method for test the attributes
	 * @param the employee to test
	 */
	private void testAttributes(Employee emp, int num) {
		assertEquals(ID, emp.getId());
		assertEquals(USERNAME, emp.getUsername());
		assertEquals(PASSWORD, emp.getPassword());
		if(num == 1)
		{
			assertEquals(ISADMIN1, emp.getIsAdmin());
			assertEquals(TPV_PRIVILEGE1, emp.getTpvPrivilege());
		}
		else
		{
			assertEquals(ISADMIN2, emp.getIsAdmin());
			assertEquals(TPV_PRIVILEGE2, emp.getTpvPrivilege());
		}

	}

	
}
