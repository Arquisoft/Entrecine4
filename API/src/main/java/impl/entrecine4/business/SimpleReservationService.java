package impl.entrecine4.business;

import java.util.Date;

import com.entrecine4.GenerateQR;
import com.entrecine4.PaymentGateway;
import com.entrecine4.SendEmail;
import com.entrecine4.business.ReservationService;

public class SimpleReservationService implements ReservationService {

	@Override
	public void generateQR(String code) {
		GenerateQR.generate(code);
	}

	@Override
	public boolean goToPaymentGategay(String cardNumber, String type,
			String SecurityCode, Date expirationDate) {
		return PaymentGateway.pay(cardNumber, type, SecurityCode, expirationDate);
	}

	@Override
	public void sendEmail(String to, String fileName) {
		SendEmail.sendNewMail(to, fileName);
	}

}
