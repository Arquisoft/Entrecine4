package com.entrecine4.business;

import com.entrecine4.business.IncidenceService;
import com.entrecine4.business.MoviesService;
import com.entrecine4.business.ReservationService;
import com.entrecine4.business.RoomService;
import com.entrecine4.business.StaffService;
import com.entrecine4.infraestructure.UserService;

public interface ServicesFactory {

	/**
	 * Method to get an implementation of IncidenceService and get access to the
	 * business layer
	 * 
	 * @return An implementation of IncidenceService
	 */
	public IncidenceService createIncidenceService();
	
	/**
	 * Method to get an implementation of MoviesService and get access to the business
	 * layer
	 * 
	 * @return An implementation of MoviesService
	 */
	public MoviesService createMoviesService();
	
	/**
	 * Method to get an implementation of PurchasesService and get access to the
	 * business layer
	 * 
	 * @return An implementation of PurchasesService
	 */
	public PurchasesService createPurchasesService();
	
	/**
	 * Method to get an implementation of ReservationService and get access to the
	 * business layer
	 * @return An implementation of ReservationService
	 */
	public ReservationService createReservationService();
	
	/**
	 * Method to get an implementation of RoomService and get access to the business
	 * layer
	 * @return An implementation of RoomService
	 */
	public RoomService createRoomService();
	
	/**
	 * Method to get an implementation of SessionService and get access to the business
	 * layer
	 * 
	 * @return An implementation of SessionService
	 */
	public SessionService createSessionService();
	
	/**
	 * Method to get an implementation of SessionStateService and get access to the
	 * business layer
	 * 
	 * @return An implementation of SessionStateService
	 */
	public SessionStateService createSessionStateService();
	
	/**
	 * Method to get an implementation of StaffService and get access to the business
	 * layer
	 * 
	 * @return An implementation of StaffService
	 */
	public StaffService createStaffService();
	
    /**
     * Method to get an implementation of UserService and get access to the business
     * layer
     * 
     * @return An implementation of UserService
     */
    public UserService createUserService();
}