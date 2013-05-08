package com.entrecine4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TicketIDCodeManager {
	
	
	
	
	/**
	 * Genera el código para la tabla de compras_usuarios_web con el código identificador
	 * de entrada en función de os asientos y de la sesión
	 * @param asientos
	 * @return
	 */
	public static String generateCode(int sesion, List<Map<String, Integer>> seats){
		String resultado = "";
		String aleatorio = "";
		Random r = new Random();
		
		// Generamos 10 caracteres aleatorios
		for(int i = 0; i < 10; i++){
			int al = r.nextInt(95) + 32;
			if(al != 59)	// NO se puede utilizar el ';' porque será el separador
				aleatorio += (char) al;
			else
				i--;
		}
		
		resultado += sesion + ";";
		
		for(Map<String, Integer> seat : seats)
			resultado += seat.get("ROW") + ";" + seat.get("COLUMN") + ";";
		
		resultado += aleatorio;
		
		return resultado;

	}
	
	public static int getSessionFromCode(String code){
		String[] parsed = code.split(";");
		
		return Integer.parseInt(parsed[0]);
	}
	
	public static List<Map<String, Integer>> getSeatsFromCode(String code){
		String[] parsed = code.split(";");
		List<Map<String, Integer>> seats = new ArrayList<Map<String,Integer>>();
		for(int i = 1; i < parsed.length - 1; i+=2){
			Map<String, Integer> seat = new HashMap<String, Integer>();
			seat.put("ROW",Integer.parseInt(parsed[i]));
			seat.put("COLUMN", Integer.parseInt(parsed[i+1]));
			
			seats.add(seat);
		}
		
		return seats;
		
	}
	

}
