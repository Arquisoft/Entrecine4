package impl.entrecine4.business;

import com.entrecine4.GenerateQR;
import com.entrecine4.PaymentGateway;
import com.entrecine4.SendEmail;
import com.entrecine4.business.ReservationService;
import com.entrecine4.infraestructure.Jdbc;
import com.entrecine4.persistence.SessionStateDAO;
import impl.entrecine4.persistence.SimplePersistenceFactory;
import models.SessionState;
import models.User;

import java.sql.Connection;
import java.sql.SQLException;

public class SimpleReservationService implements ReservationService {
	
	private SessionStateDAO dao = new SimplePersistenceFactory().createSessionStateDAO();

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
			String SecurityCode, String expirationDate) {
		return PaymentGateway.pay(cardNumber, type, SecurityCode, expirationDate);
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
		//considerar la opcion de meter el email en la clase user
		if(user.hasEmptyFields())
			return null;
		return user;
	}

	/* (non-Javadoc)
	 * @see com.entrecine4.business.ReservationService#lockSeat(com.entrecine4.model.SessionState)
	 */
	@Override
	public void lockSeat(SessionState sessionState) {
        Connection con = Jdbc.getConnection();
        try {
            dao.setConnection(con);
            dao.save(sessionState);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Jdbc.close(con);
        }
	}

}