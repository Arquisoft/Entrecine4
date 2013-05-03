package impl.entrecine4.business;

import models.User;

import com.entrecine4.GenerateQR;
import com.entrecine4.PaymentGateway;
import com.entrecine4.SendEmail;
import com.entrecine4.business.ReservationService;

public class SimpleReservationService implements ReservationService 
{

	/* (non-Javadoc)
	 * @see com.entrecine4.business.ReservationService#generateQR(java.lang.String)
	 */
	@Override
	public void generateQR(String code) {
		GenerateQR.generate(code);
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.ReservationService#goToPaymentGategay(java.lang.String, java.lang.String, java.lang.String, java.util.Date)
	 */
	@Override
	public boolean goToPaymentGategay(String cardNumber, String type,
			String securityCode, String expirationDate) {
		return PaymentGateway.pay(cardNumber, type, securityCode, expirationDate);
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.ReservationService#sendEmail(java.lang.String, java.lang.String)
	 */
	@Override
	public void sendEmail(String to, String fileName) {
		SendEmail.sendNewMail(to, fileName);
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.ReservationService#validateUserData(com.entrecine4.model.User)
	 */
	@Override
	public User validateUserData(User user) {
		if(user.hasEmptyFields())
			return null;
		
		String email = user.getEmail();
		
		if(!email.matches(".+@.+\\..+"))
			return null;
		
		return user;
	}
}