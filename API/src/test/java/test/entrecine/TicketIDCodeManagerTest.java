package test.entrecine;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.entrecine4.TicketIDCodeManager;

public class TicketIDCodeManagerTest {

	@Test
	public void testSeats() {

		List<Map<String, Integer>> seats = new ArrayList<Map<String, Integer>>();

		Map<String, Integer> mapa = new HashMap<String, Integer>();
		mapa.put("ROW", 5);
		mapa.put("COLUMN", 6);

		Map<String, Integer> mapa2 = new HashMap<String, Integer>();
		mapa2.put("ROW", 7);
		mapa2.put("COLUMN", 8);

		Map<String, Integer> mapa3 = new HashMap<String, Integer>();
		mapa3.put("ROW", 9);
		mapa3.put("COLUMN", 10);

		seats.add(mapa);
		seats.add(mapa2);
		seats.add(mapa3);
		

		assertTrue(seats
				.equals(TicketIDCodeManager.getSeatsFromCode(TicketIDCodeManager.generateCode(4, seats))));
	}
	
	@Test
	public void testSession() {

		List<Map<String, Integer>> seats = new ArrayList<Map<String, Integer>>();

		Map<String, Integer> mapa = new HashMap<String, Integer>();
		mapa.put("ROW", 5);
		mapa.put("COLUMN", 6);

		Map<String, Integer> mapa2 = new HashMap<String, Integer>();
		mapa2.put("ROW", 7);
		mapa2.put("COLUMN", 8);

		Map<String, Integer> mapa3 = new HashMap<String, Integer>();
		mapa3.put("ROW", 9);
		mapa3.put("COLUMN", 10);

		seats.add(mapa);
		seats.add(mapa2);
		seats.add(mapa3);
		
		assertEquals(4, TicketIDCodeManager.getSessionFromCode(TicketIDCodeManager.generateCode(4, seats)));

		}

}
