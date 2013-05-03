package com.entrecine4.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.Employee;


public interface EmployeeDAO {
	/**
	 * Set the connection that will be used
	 * @param con
	 */
	public void setConnection(Connection con);
	
	/**
	 * Returns the employee
	 * @param employeeID
	 * @return
	 * @throws SQLException
	 */
	public Employee get(long employeeID) throws SQLException;
	
	/**
	 * Returns a list of all the employees
	 * @return
	 * @throws SQLException
	 */
	public List<Employee> getAll() throws SQLException;
	
	/**
	 * Saves a new Employee in the Database
	 * @param employee
	 * @throws SQLException
	 */
	public void save(Employee employee) throws SQLException;
	
	/**
	 * Updates the information of an employee
	 * @param employee
	 * @throws SQLException
	 */
	public void update(Employee employee) throws SQLException;
	
	/**
	 * Deletes an employee
	 * @param employee
	 * @throws SQLException
	 */
	public void delete(Employee employee) throws SQLException;

}
