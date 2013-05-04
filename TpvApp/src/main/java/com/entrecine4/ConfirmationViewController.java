/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecine4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void cancel(ActionEvent event) throws IOException{
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
}
