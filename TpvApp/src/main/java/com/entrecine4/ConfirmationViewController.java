/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecine4;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.entrecine4.business.SessionStateService;
import com.entrecine4.infraestructure.Factories;

import models.SessionState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alberto
 */
public class ConfirmationViewController implements Initializable {
    
    @FXML
    private Label precio;    
    @FXML
    private Label numeroEntradas;    
    @FXML
    private Label sesion;
    @FXML
    private Label pelicula;
    
    private SessionStateService sessionStateService;
    
    private double price;
	private double hour;
    private String movie;
    private List<SessionState> reservations;

    

    /**
     * Initializes the controller class.
     */
    @SuppressWarnings("unchecked")
	@Override
    public void initialize(URL url, ResourceBundle rb) {        
        sessionStateService = Factories.services.createSessionStateService();
        updateView();
    }
    
    public void updateView(){
    	precio.setText(String.valueOf(price));
        numeroEntradas.setText(String.valueOf(reservations.size()));
        sesion.setText(String.valueOf(hour));
        pelicula.setText(movie);
    }
    
    @FXML
    private void cancel(ActionEvent event) throws IOException{
    	deleteReservations();

        ((Stage) sesion.getScene().getWindow()).close(); //close current window
        Parent rootNode = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));
        
        Scene scene = new Scene(rootNode);        

        Stage stage = new Stage();
       
        stage.setTitle("Confirmar compra - Entrecine4");
        stage.setScene(scene);
        stage.show();
    }
    
     @FXML
    private void accept(ActionEvent event) throws IOException{
         ((Stage) sesion.getScene().getWindow()).close(); //close current window
          
        Parent rootNode = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = new Stage();

        stage.setTitle("Venta de entradas - Entrecine4");
        stage.setScene(scene);
        stage.show();
    }
     
    private void deleteReservations(){
    	for(SessionState s : reservations){
    		sessionStateService.deleteSessionState(s);
    	}
    }
    
    public void setPrice(double price) {
 		this.price = price;
 	}

 	public void setHour(double hour) {
 		this.hour = hour;
 	}

 	public void setMovie(String movie) {
 		this.movie = movie;
 	}

 	public void setReservations(List<SessionState> reservations) {
 		this.reservations = reservations;
 	}

}
