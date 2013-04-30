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
<<<<<<< HEAD
    	List<Movie> movies = Factories.services.createMoviesService().getMovies();
        return ok(index.render(movies, userForm));
=======
//    	Descomentar esta línea cuando este terminada la API. Ahora "casca" por que no
//    	está sobreescrito el método createMoviesServie de servicesfactory con la implementación
//    	List<Movie> movies = Factories.services.createMoviesService().getMovies();
//    	El formato de la película debe ser el siguiente (path de imágenes correcto)
//    	movies.add(new Movie(1, "Spiderman", "Está muy bien", "/assets/stylesheets/images/small/1.jpg", 5, 4, 6));
//        return ok(index.render(movies, userForm));
    	return ok(index.render(new ArrayList<Movie>(), userForm));
>>>>>>> Añadido ejemplo de funcionalidad para mostrar la cartelera y comentarios
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
    
    public static Result plataformaPago(){
    	return ok(plataformaPago.render(userForm));
    }
}
