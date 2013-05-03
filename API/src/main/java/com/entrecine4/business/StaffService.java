package com.entrecine4.business;

import java.util.List;

import models.Employee;


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
	 * 			Employee ID
	 * @return the employee
	 */
	public Employee findById(Long id);

	/**
	 * Save an employee
	 * @param employee
	 * 					Employee to be saved
	 */
	public void saveEmployee(Employee employee);
	
	/**
	 * Update an employee
	 * @param employee
	 * 					Employee to be updated
	 */
	public void updateEmployee(Employee employee);
	
	
	/**
	 * Delete an employee
	 * @param employee
	 * 					Employee to be deleted
	 */
	public void deleteEmployee(Employee employee);

}
