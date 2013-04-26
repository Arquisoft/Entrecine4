package com.entrecine4.business;

import com.entrecine4.business.IncidenceService;
import com.entrecine4.business.MoviesService;
import com.entrecine4.business.ReservationService;
import com.entrecine4.business.RoomService;
import com.entrecine4.business.StaffService;

public interface ServicesFactory {

	/**
	 * Method to get an instance of IncidenceService and get access to the business layer
	 * @return An instance of IncidenceService
	 */
	public IncidenceService createIncidenceService();
	/**
	 * Method to get an instance of MoviesService and get access to the business layer
	 * @return An instance of MoviesService
	 */
	public MoviesService createMoviesService();
	/**
	 * Method to get an instance of ReservationService and get access to the business layer
	 * @return An instance of ReservationService
	 */
	public ReservationService createReservationService();
	/**
	 * Method to get an instance of RoomService and get access to the business layer
	 * @return An instance of RoomService
	 */
	public RoomService createRoomService();
	/**
	 * Method to get an instance of StaffService and get access to the business layer
	 * @return An instance of StaffService
	 */
	public StaffService createStaffService();
}