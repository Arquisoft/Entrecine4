package controllers;

import java.util.ArrayList;
import java.util.List;
import com.entrecine4.infraestructure.*;

import com.entrecine4.*;

import play.*;
import play.mvc.*;
import play.data.Form;
import models.*;

import views.html.*;

public class Application extends Controller {
	
	static Form<User> userForm = Form.form(User.class);
  
    public static Result index() {
    	List<Movie> movies = Factories.services.createMoviesService().getMovies();
        return ok(index.render(movies, userForm));
    }

    public static Result registro() {
        return ok(registro.render());
    }

    public static Result pelicula(Long id) {
        Movie movie = Factories.services.createMoviesService().findById(id);
        return ok(pelicula.render(movie));
    }
    
    public static Result login() {
    	Form<User> filledForm = userForm.bindFromRequest();
    	System.out.println(filledForm.toString());
    	return ok(index.render(new ArrayList<Movie>(), userForm));
    }
}
