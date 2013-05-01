package com.entrecine4;

import java.util.Date;
import java.util.Random;

/**
 * This class will simulate a payment gateway
 * 
 * 
 */
public class PaymentGateway {

	/**
	 * Simulates a payment procedure. One each 10 times it will simulate that there
	 * has been a failure in the payment process.
	 * @param cardNumber Number of the credit/debit card
	 * @param type MasterCard, Visa, ...
	 * @param SecurityCode Security Code
	 * @param expirationDate Expiration Date of the Credit/Debit Card. For security reasons.
	 * @return
	 */
	public static boolean pay(String cardNumber, String type, String SecurityCode, String expirationDate){
		Random r = new Random();
		if(r.nextInt(10) < 1)
			return false;
		else
			return true;
	}
}
