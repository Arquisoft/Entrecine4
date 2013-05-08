package test.entrecine.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import models.Employee;

import org.junit.Test;

import com.entrecine4.business.StaffService;
import com.entrecine4.infraestructure.Factories;

public class StaffServiceTest 
{
	private StaffService service = Factories.services.createStaffService();
	
	/**
	 * Method that tests the recovering of all the employees from the database
	 */
	@Test
	public void testGetAllEmployees() 
	{
		List<Employee> staff = service.getStaff();
		
		assertEquals(45, staff.get(0).getId());
		assertEquals(46, staff.get(1).getId());
	}
	
	/**
	 * Method that tests the recovering of an employee using his identification number
	 */
	@Test
	public void testFindByID()
	{
		Employee employee = service.findById(45L);
		
		assertEquals("manuel", employee.getUsername());
		assertEquals("prueba", employee.getPassword());
		assertEquals(1, employee.getIsAdmin());
		assertEquals(1, employee.getTpvPrivilege());
	}
	
	/**
	 * Method that tests the saving of an employee into the database, checks if
	 * the saved employee data is the same, and then deletes it from the database
	 */
	@Test
	public void testSaveDeleteEmployee()
	{
		Employee employee = new Employee(0, "test", "test", 1, 0);
		service.saveEmployee(employee);
		
		List<Employee> staff = service.getStaff();
		Long id = staff.get(staff.size()-1).getId();
		
		Employee savedEmployee = service.findById(id);
		
		assertEquals(employee.getUsername(), savedEmployee.getUsername());
		assertEquals(employee.getPassword(), savedEmployee.getPassword());
		assertEquals(employee.getIsAdmin(), savedEmployee.getIsAdmin());
		assertEquals(employee.getTpvPrivilege(), savedEmployee.getTpvPrivilege());
		
		service.deleteEmployee(savedEmployee);
		
		Employee deletedEmployee = service.findById(id);
		assertEquals(null, deletedEmployee);
	}
	
	/**
	 * Method that tests the updating of an employee's data, checks if the updating
	 * was correct, and then updates it back to the initial data
	 */
	@Test
	public void testUpdateEmployee()
	{
		Employee employee = service.findById(45L);
		
		assertEquals("manuel", employee.getUsername());
		assertEquals("prueba", employee.getPassword());
		assertEquals(1, employee.getIsAdmin());
		assertEquals(1, employee.getTpvPrivilege());
		
		employee.setIsAdmin(0);
		employee.setTpvPrivilege(0);
		
		service.updateEmployee(employee);
		Employee updatedEmployee = service.findById(45L);
		
		assertEquals(employee.getIsAdmin(), updatedEmployee.getIsAdmin());
		assertEquals(employee.getTpvPrivilege(), updatedEmployee.getTpvPrivilege());
		
		employee.setIsAdmin(1);
		employee.setTpvPrivilege(1);
		service.updateEmployee(employee);
	}

}
