package com.entrecine4.business;

import java.util.List;

import com.entrecine4.model.Incidence;

public interface IncidenceService {

	
	/**
	 * Retrieve all the incidences
	 * @return the incidences
	 */
	public List<Incidence> getInicidences();
	
	/**
	 * Retrieve one incidence
	 * @param id 
	 * @return the incidence
	 */
	public Incidence findById(Long id);

	/**
	 * Save an incidence
	 * @param incidence
	 */
	public void saveIncidence(Incidence incidence);
	
	/**
	 * Update an incidence
	 * @param incidence
	 */
	public void updateIncidence(Incidence incidence);
	
	/**
	 * Delete an incidence
	 * @param incidence
	 */
	public void deleteIncidence(Incidence incidence);
}
