package test.entrecine.model;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.junit.Test;
import com.entrecine4.model.SessionState;


/**
 * @author Arquisoft - Entrecine4
 *
 */
public class SessionStateTest {

	private SessionState sessionState1;
	private SessionState sessionState2;
	
	private final static long ROOM_ID = 12;
	private final static int ROW = 3;
	private final static int COLUMN = 8;
	private final static Date DATE = new Date();
	private final static long SESSION = 4;
	

	/**
	 * Test without parameters, this will test setters
	 */
	@Test
	public void testWithoutParameters() {
		sessionState1 = new SessionState();
		sessionState1.setRoomId(ROOM_ID);
		sessionState1.setRow(ROW);
		sessionState1.setColumn(COLUMN);
		sessionState1.setDate(DATE);
		sessionState1.setSession(SESSION);
		testAttributes(sessionState1);
	}
	
	/**
	 * Test with parameters, this will test getters and parameterized constructor
	 */
	@Test
	public void testWithParameters() {
		sessionState2 = new SessionState(ROOM_ID, ROW, COLUMN, DATE, SESSION);
		testAttributes(sessionState2);
	}

	/**
	 * Method for test the attributes
	 * @param the user to test
	 */
	private void testAttributes(SessionState sessionState) {
		assertEquals(sessionState.getRoomId(), ROOM_ID);
		assertEquals(sessionState.getRow(), ROW);
		assertEquals(sessionState.getColumn(), COLUMN);
		assertEquals(sessionState.getDate(), DATE);
		assertEquals(sessionState.getSession(), SESSION);
	}

}
