package es.uniovi.asw.entrecine;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.runtime.PendingException;

public class RegistroSteps {
	
	
	@Dado("^un usuario no registrado de nombre David$")
	public void un_usuario_no_registrado_de_nombre_David() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Cuando("^se registra con usuario david y contraseña david$")
	public void se_registra_con_usuario_david_y_contraseña_david() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
	
	@Entonces("^el resultado al buscar en la base de datos es verdadero$")
	public void el_resultado_al_buscar_en_la_base_de_datos_es_verdadero() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Dado("^un usuario ya existente de nombre David$")
	public void un_usuario_ya_existente_de_nombre_David() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Cuando("^se intenta registrar un usuario con el mismo username$")
	public void se_intenta_registrar_un_usuario_con_el_mismo_username() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Entonces("^el sistema da un error$")
	public void el_sistema_da_un_error() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}


}