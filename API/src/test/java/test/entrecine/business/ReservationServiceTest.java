package test.entrecine.business;

import static org.junit.Assert.*;

import models.User;

import org.junit.Test;

import com.entrecine4.business.ReservationService;
import com.entrecine4.infraestructure.Factories;

/**
 * Only have sense test this methods, the other ones need manual testing
 */
public class ReservationServiceTest 
{
	private ReservationService service = Factories.services.createReservationService();
	
	/**
	 * Method to test if the validation of the user data is right
	 */
	@Test
	public void testValidationUserData() 
	{
		User user=new User(1,"a","a","a","a","a");
		assertEquals(null, service.validateUserData(user));
		
		user.setName(null);
		assertEquals(null,service.validateUserData(user));
		user.setName("a");
		
		user.setEmail("addf@qwerty.com");
		assertEquals(user, service.validateUserData(user));
		
		user.setEmail("qwerty@qwerty");
		assertEquals(null,service.validateUserData(user));

		user.setEmail("qwerty.com");
		assertEquals(null,service.validateUserData(user));
		
		user.setEmail("@qwerty.com");
		assertEquals(null,service.validateUserData(user));
	}
	
	/**
	 * Method to use a lot of times the payment gateway method and prevent exceptions
	 */
	@Test
	public void testPaymentGateway()
	{
		String cardNumber="5875213";
		String type="Debit";
		String securityCode="1234";
		String expirationDate="20-2-2105";
		
		for(int i=0;i<1000;i++)
			service.goToPaymentGategay(cardNumber, type, securityCode, expirationDate);
	}
}