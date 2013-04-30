package models;

import java.util.ArrayList;
import java.util.List;


public class Movie {

	public long id;
	public String name;
	public String synopsis;
	public String imgPath;
	public double morningPrice;
	public double dailyPrice;
	public double nightPrice;
	
	public Movie() {
		// hay que cambiar esto porque es una m...
		this.id=1;
		this.name="FUNCIONA";
	}
	
	
	public static List<Movie> getAll(){
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie());
		return movies;
	}
	
}
