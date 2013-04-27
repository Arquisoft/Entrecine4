package es.uniovi.asw.entrecine.cases;

import static org.fest.assertions.Assertions.assertThat;

import com.entrecine4.Reservation;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dada;
import cucumber.api.java.es.Entonces;
import cucumber.runtime.PendingException;

public class ReservasSteps {

	private Reservation r;

	@Dada("^una reserva de (\\d+) butacas con un precio de (\\d+) euros$")
	public void una_reserva_de_butacas(int seats, double price)
			throws Throwable {
		r = new Reservation(seats, price);
	}

	@Cuando("^Yo pregunto por el precio total$")
	public void Yo_pregunto_precio_total() throws Throwable {
	}

	@Entonces("^el resultado debe ser (\\d+)$")
	public void el_resultado_debe_ser(double total) throws Throwable {
		assertThat(total).isEqualTo(r.getPrice());
	}

	@Dada("^una reserva de (\\d+) butaca$")
	public void una_reserva_de_butaca(int arg1) throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Cuando("^el usuario intenta reservar esa misma butaca$")
	public void el_usuario_intenta_reservar_esa_misma_butaca() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Entonces("^el sistema deberá generar un error$")
	public void el_sistema_deberá_generar_un_error() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Dada("^una reserva en el día actual$")
	public void una_reserva_en_el_día_actual() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Cuando("^el usuario intenta comprar para dentro de (\\d+) días$")
	public void el_usuario_intenta_comprar_para_dentro_de_días(int arg1)
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Cuando("^el usuario intenta comprar para la sesión anterior$")
	public void el_usuario_intenta_comprar_para_la_sesión_anterior()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Dada("^una reserva válida de una butaca para la siguiente sesión$")
	public void una_reserva_válida_de_una_butaca_para_la_siguiente_sesión()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Cuando("^yo pregunto por la reserva$")
	public void yo_pregunto_por_la_reserva() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Entonces("^el resultado debe ser el mismo que la reserva$")
	public void el_resultado_debe_ser_el_mismo_que_la_reserva()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Cuando("^el cliente paga con una tarjeta inválida$")
	public void el_cliente_paga_con_una_tarjeta_inválida() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Entonces("^el sistema debe generar un error y borrar los datos de la transacción$")
	public void el_sistema_debe_generar_un_error_y_borrar_los_datos_de_la_transacción()
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Dada("^una reserva de un usuario en la web$")
	public void una_reserva_de_un_usuario_en_la_web() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Cuando("^el cliente acaba la transacción$")
	public void el_cliente_acaba_la_transacción() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Entonces("^el sistema debe emitirle un comprobante$")
	public void el_sistema_debe_emitirle_un_comprobante() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}
	
	@Dada("^una reserva del asiento (\\d+) en la fila (\\d+)$")
	public void una_reserva_del_asiento_en_la_fila(int arg1, int arg2) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Cuando("^Yo pregunto por la reserva del asiento (\\d+) en la fila (\\d+)$")
	public void Yo_pregunto_por_la_reserva_del_asiento_en_la_fila(int arg1, int arg2) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Entonces("^el sistema debe decir que está ocupada$")
	public void el_sistema_debe_decir_que_está_ocupada() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

}