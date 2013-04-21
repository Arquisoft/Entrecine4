package com.entrecine4.persistence;

import java.sql.SQLException;
import java.util.List;

import com.entrecine4.model.Incidence;

//TODO:No JUnit till all the questions are solved
public interface IncidenceDAO
{
	//TODO:How to find an incidence
	public Incidence get() throws SQLException;
	
	/**
	 * Method to get all the incidences from the database
	 * 
	 * @return A list containing all the incidences stored in the database
	 * @throws SQLException 
	 */
	public List<Incidence> getAll() throws SQLException;
	
	/**
	 * Method to save an incidence in the database
	 * 
	 * @param incidence The instance of Incidence to be saved
	 * @throws SQLException 
	 */
	public void save(Incidence incidence) throws SQLException;
	
	/**
	 * Method to update the data of an incidence in the database
	 * 
	 * @param incidence The instance of Incidence to be updated
	 * @throws SQLException 
	 */
	public void update(Incidence incidence) throws SQLException;
	
	/**
	 * Method to delete an incidence from the database
	 * 
	 * @param incidence The instance of Incidence to be deleted
	 */
	public void delete(Incidence incidence) throws SQLException;
}