package com.entrecine4.business;

import java.util.Date;

import models.SessionState;
import models.User;


public interface ReservationService {

	/**
	 * Generates a QR code from a string
	 * 
	 * @param code
	 *            The string
	 */
	public void generateQR(String code);

	/**
	 * Simulates a payment procedure. One each 10 times it will simulate that
	 * there has been a failure in the payment process.
	 * 
	 * @param cardNumber
	 *            Number of the credit/debit card
	 * @param type
	 *            MasterCard, Visa, ...
	 * @param SecurityCode
	 *            Security Code
	 * @param expirationDate
	 *            Expiration Date of the Credit/Debit Card. For security
	 *            reasons.
	 * @return
	 */
	public boolean goToPaymentGategay(String cardNumber, String type,
			String SecurityCode, String expirationDate);

	/**
	 * Method for send the email with the QR code
	 * 
	 * @param email
	 *            to send
	 * @param fileName
	 *            of the QR code
	 */
	public void sendEmail(String to, String fileName);

	/**
	 * Method for checking the different user's fields
	 * 
	 * @param user
	 *            The user
	 * @return the user that is going to be checked
	 */
	public User validateUserData(User user);
	
	/**
	 * Method for lock a seat
	 * @param sessionState
	 */
	public void lockSeat(SessionState sessionState);
}
