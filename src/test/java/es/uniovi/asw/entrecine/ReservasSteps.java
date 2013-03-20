package es.uniovi.asw.entrecine;

import static org.fest.assertions.Assertions.assertThat;
import cucumber.api.Format;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.es.Dada;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Cuando;
import cucumber.runtime.PendingException;
import es.uniovi.asw.entrecine.Reservation;

public class ReservasSteps {
	
	private Reservation r;
	
	@Dada("^una reserva de (\\d+) butacas con un precio de (\\d+) euros$")
	public void una_reserva_de_butacas(int seats, double price) throws Throwable {
	    r = new Reservation(seats,price);
	}

	@Cuando("^Yo pregunto por el precio total$")
	public void Yo_pregunto_precio_total() throws Throwable {
	}

	@Entonces("^el resultado debe ser (\\d+)$")
	public void el_resultado_debe_ser(double total) throws Throwable {
		assertThat(total).isEqualTo(r.getPrice());
	}

}