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
        int begin = Integer.valueOf(cardNumber.substring(0,1));
        if(cardNumber.length()!=16) //all cards have the same number of digits
            return false;
        else if(type.equals("American Express") && begin!=3)
            return false; //for American Express it must begin with 3
        else if(type.equals("Visa") && begin!=4)
            return false; //for Visa it must begin with 4
        else if(type.equals("Mastercard") && begin!=5)
            return false; //for Mastercard it must begin with 5
		Random r = new Random();
		if(r.nextInt(10) < 1)
			return false;
		else
			return true;
	}
}
