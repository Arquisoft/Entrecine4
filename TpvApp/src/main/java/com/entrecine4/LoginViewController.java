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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
}
