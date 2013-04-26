package com.entrecine4.business;

import java.util.Date;

public interface ReservationService {

	public void generateQR(String code);
	public boolean goToPaymentGategay(String cardNumber, String type, String SecurityCode, Date expirationDate);
	public void sendEmail(String to, String fileName);
}
