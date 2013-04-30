package com.entrecine4.business;

import java.util.List;

import models.Incidence;


public interface IncidenceService {

	
	/**
	 * Retrieve all the incidences
	 * @return the incidences
	 */
	public List<Incidence> getIncidences();
	
	/**
	 * Retrieve one incidence
	 * @param id 
	 * 			Incidence ID
	 * @return the incidence
	 */
	public Incidence findById(Long id);

	/**
	 * Save an incidence
	 * @param incidence
	 * 					Incidence to be saved
	 */
	public void saveIncidence(Incidence incidence);
	
	/**
	 * Update an incidence
	 * @param incidence
	 * 					Incidence to be updated
	 */
	public void updateIncidence(Incidence incidence);
	
	/**
	 * Delete an incidence
	 * @param incidence
	 * 					Incidence to be deleted
	 */
	public void deleteIncidence(Incidence incidence);
}
