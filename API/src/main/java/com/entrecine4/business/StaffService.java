package com.entrecine4.business;

import java.util.List;

import com.entrecine4.model.Employee;

public interface StaffService {
	
	/**
	 * Retrieve all the employees
	 * @return the employees
	 */
	public List<Employee> getStaff();
	
	/**
	 * Retrieve a employee
	 * 
	 * @param id
	 * @return the employee
	 */
	public Employee findById(Long id);

	/**
	 * Save an employee
	 * @param employee
	 */
	public void saveEmployee(Employee employee);
	
	/**
	 * Update an employee
	 * @param employee
	 */
	public void updateEmployee(Employee employee);
	
	
	/**
	 * Delete an employee
	 * @param employee
	 */
	public void deleteEmployee(Employee employee);

}
