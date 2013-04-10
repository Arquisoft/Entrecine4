package es.uniovi.asw.entrecine.cases;

import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dadas;
import cucumber.api.java.es.Entonces;
import cucumber.runtime.PendingException;

public class CarteleraSteps {
	
	@Dadas("^unas peliculas con los siguientes datos:$")
	public void unas_peliculas_con_los_siguientes_datos(DataTable arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    // For automatic conversion, change DataTable to List<YourType>
	    throw new PendingException();
	}

	@Cuando("^Yo miro la cartelera para el día de hoy (\\d+)/(\\d+)/(\\d+) a las (\\d+) am$")
	public void Yo_miro_la_cartelera_para_el_día_de_hoy_a_las_am(int arg1, int arg2, int arg3, int arg4) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Entonces("^el resultado debe de ser:$")
	public void el_resultado_debe_de_ser(DataTable arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    // For automatic conversion, change DataTable to List<YourType>
	    throw new PendingException();
	}

	@Cuando("^Yo miro la cartelera para mañana siendo hoy (\\d+)/(\\d+)/(\\d+) a las (\\d+) am$")
	public void Yo_miro_la_cartelera_para_mañana_siendo_hoy_a_las_am(int arg1, int arg2, int arg3, int arg4) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}


}
