package es.uniovi.asw.entrecine;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.Format;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.es.Dada;
import cucumber.api.java.es.Dadas;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Cuando;
import cucumber.runtime.PendingException;
import es.uniovi.asw.entrecine.Reservation;

public class TablaReservasSteps {
	
	private List<Reservation> reservations = new ArrayList<Reservation>();
	int indice;
	
	@Dadas("^las siguientes reservas:$")
	public void las_siguientes_reservas(List<Entry> entries) throws Throwable {
		for (Entry e : entries) {
			reservations.add(new Reservation(e.butacas,e.precio));
		}
	}

	@Cuando("^Yo busco el precio de la reserva (\\d+)$")
	public void Yo_busco_el_precio_de_la_reserva(int valor) throws Throwable {
		indice = valor - 1 ;
	}
	
	@Entonces("^el resultado de ese valor debe ser (\\d+)$")
	public void el_resultado_debe_ser(double total) throws Throwable {
		Double totalCalculated = reservations.get(indice).getPrice();
		assertThat(total).isEqualTo(totalCalculated);
	}
	
	public class Entry {
        Integer butacas;
        Integer precio;
    }

}
