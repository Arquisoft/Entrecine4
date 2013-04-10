package es.uniovi.asw.entrecine.unit;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Una vez modificado el main borrar para que pase pruebas
 * @author Herminio
 *
 */
public class SimpleTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@Test
	public void out() {
		String hola = "Hola mundo";
	    System.out.print(hola);
	    assertEquals(hola, outContent.toString());
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	

}