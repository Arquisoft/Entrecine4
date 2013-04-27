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
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Arquisoft - Entrecine4
 */
public class LoginController implements Initializable {
    @FXML
    private Font x1;
    @FXML
    private TextField txUsername;
    @FXML
    private PasswordField txPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException {
    	if(txUsername.getText().equals("admin") && txPassword.getText().equals("admin")) {
    		((Stage) txUsername.getScene().getWindow()).close(); //close current window
    		showMainWindow();
    	} else {
    		txUsername.setText(""); 
    		txPassword.setText("");
    	}
    }
    
    /**
     * This method shows the main window
     * @throws IOException
     */
	private void showMainWindow() throws IOException {
		String fxmlFile = "/fxml/mainWindow.fxml";
		FXMLLoader loader = new FXMLLoader();
		Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

		Scene scene = new Scene(rootNode);
		scene.getStylesheets().add("/styles/JMetroLightTheme.css");

		Stage stage = new Stage();
		
		stage.sizeToScene();
		
		stage.setTitle("Venta de entradas - Entrecine4");
		stage.setScene(scene);
		stage.show();
	}
}
