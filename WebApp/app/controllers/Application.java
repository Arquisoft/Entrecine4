package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render());
    }

    public static Result registro() {
        return ok(registro.render());
    }

    public static Result pelicula(Long id) {
        return ok(pelicula.render(id));
    }

}
