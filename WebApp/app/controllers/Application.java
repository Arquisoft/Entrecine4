package controllers;

import java.util.ArrayList;
import java.util.List;
import com.entrecine4.infraestructure.*;

import com.entrecine4.*;

import play.*;
import play.api.libs.Crypto;
import play.mvc.*;
import play.data.Form;
import models.*;

import views.html.*;


public class Application extends Controller {
	
	static Form<User> userForm = Form.form(User.class);
	static Form<PaymentData> paymentForm = Form.form(PaymentData.class);
  
    public static Result index() {
        Http.Cookie cookie = request().cookies().get("user"); //must be decrypted
        String user = null;
        List<Movie> movies = Factories.services.createMoviesService().getMovies();
        if(cookie != null) {
            user = Crypto.decryptAES(cookie.value()); //if not null decrypt
        }
        if(Factories.services.createUserService().get(user) == null) // user exists?
            return ok(index.render(null,movies, userForm));
        return ok(index.render(user,movies, userForm));
    }

    public static Result registro() 
    {
        return ok(registro.render(userForm));
    }
    
    public static Result register()
    {
    	Form<User> filledForm = userForm.bindFromRequest();
    	if(filledForm.hasErrors()) 
    	{
    		return redirect(routes.Application.registro());
    	}
    	else
    	{
    		String name=filledForm.field("txt_Nombre").value();
    		String surnames=filledForm.field("txt_Apellidos").value();
    		String username=filledForm.field("txt_NombreDeUsuario").value();
    		String email=filledForm.field("email").value();
    		String password=filledForm.field("pwd_Contraseña").value();
    		String repass=filledForm.field("pwd_Repitalacontraseña").value();
    		
    		if(!password.equals(repass))
    			return redirect(routes.Application.registro());
    		else
    		{
    			User user=new User(0, username, password, name, surnames, email);
    			if(Factories.services.createReservationService()
    					.validateUserData(user)==null)
    				return redirect(routes.Application.registro());
    		}
    		
    		System.out.println(filledForm.toString());
    	}
    	return redirect(routes.Application.index());
    }

    public static Result pelicula(Long id) {
        Movie movie = Factories.services.createMoviesService().findById(id);
        return ok(pelicula.render(movie));
    }
    
    public static Result login() {
    	Form<User> filledForm = userForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            filledForm.reject("password", "Los datos de login están mal");
        } else {
            String username = filledForm.field("username").value();
            String password = filledForm.field("password").value();
            User user = Factories.services.createUserService().login(username, password);
            if(user == null) {
                filledForm.reject("password", "Los datos de login están mal");
            } else {
      //          session().put("user", username); // this doesn´t work, FUCKING BUG
                response().setCookie("user", Crypto.encryptAES(username), -1);
                List<Movie> movies = Factories.services.createMoviesService().getMovies();
                return redirect(routes.Application.index());
            }
        } return redirect(routes.Application.index());
    }

    public static Result logout() {
        response().discardCookie("user");
        return redirect(routes.Application.index());
    }
    
    public static Result plataformaPago(){
    	return ok(plataformaPago.render(userForm));
    }
    
    public static Result pay(){
    	Form filledForm = paymentForm.bindFromRequest();
    	System.out.println("FORMULARIO:\n" + filledForm.toString());
    	/*Ahora debo llamar al método de pasarela de pago de la API que me devuelve
    	si ha sido posible completar la transacción o no, en función de lo cual
    	redirijo a la página de error o a la de agradecimiento */
    	String numeroTarjeta = filledForm.field("numeroTarjeta").value();
//    	System.out.println("Numero Tarjeta: "+ numeroTarjeta);
    	String tipoTarjeta  = filledForm.field("tipoTarjeta").value();
//    	System.out.println("Tipo Tarjeta: "+  tipoTarjeta);
    	String codigoSeguridad = filledForm.field("codigoSeguridad").value();
//    	System.out.println("Codigo de seguridad: "+ codigoSeguridad);
    	String fechaNacimiento = filledForm.field("fechaNacimiento").value();
//    	System.out.println("Fecha de nacimiento: "+ fechaNacimiento);
    	
    	/*ESTE CONDICIONAL NO FUNCIONA: Debería funcionar, pero salta error en tiempo de ejecución,
    	 * como que no existe la función a la que se está llamando. Revistar qué es lo que no funciona.*/
//    	if(PaymentGateway.pay(numeroTarjeta, tipoTarjeta, codigoSeguridad, fechaNacimiento))
    		return redirect(routes.Application.finReservaOk());
//    	else
//    		return redirect(routes.Application.finReservaWrong());

    }
    
    public static Result finReservaOk(){
    	return ok(finReservaOk.render());
    }
    
    public static Result finReservaWrong(){
    	return ok(finReservaWrong.render());
    }
}
