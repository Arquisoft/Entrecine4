/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecine4;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import models.Employee;

import com.entrecine4.infraestructure.Factories;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Alberto
 */
public class LoginViewController implements Initializable {

    @FXML
    private TextField txUsername;
    @FXML
    private PasswordField txPassword;
    
    private List<Employee> staff;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	//staff = Factories.services.createStaffService().getStaff();
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        if (txUsername.getText().equals("") && txPassword.getText().equals("")) {
            ((Stage) txUsername.getScene().getWindow()).close(); //close current window
            showMainWindow();
        } else {
            txUsername.setText("");
            txPassword.setText("");
        }
    }

    private void showMainWindow() throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = new Stage();

        stage.setTitle("Venta de entradas - Entrecine4");
        stage.setScene(scene);
        stage.show();
    }
    
    private boolean checkEmployee(){
    	String name = txUsername.getText();
    	String password = txPassword.getText();
    	
    	for(Employee e : staff){
    		if(e.getUsername().equals(name) && e.getPassword().equals(password) && e.getTpvPrivilege() == 1){
    			return true;
    		}
    	}
    	return false;
    }
}
