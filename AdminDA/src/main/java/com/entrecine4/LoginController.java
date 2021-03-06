package com.entrecine4;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import models.Employee;

import com.entrecine4.business.StaffService;
import com.entrecine4.infraestructure.Factories;


public class LoginController implements Initializable {

	private StaffService service = Factories.services.createStaffService();
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

    /**
     * It checks if the user is administrator
     * @param event
     * @throws IOException
     */
    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException {
        if (validateUser()) {
            ((Stage) txUsername.getScene().getWindow()).close(); //close current window
            showMainWindow();
        } else {
            txUsername.setText("");
            txPassword.setText("");
        }
    }

    /**
     * It checks if the username exists, the password coincides and if it's admin
     * @return true if all of this are true
     */
    private boolean validateUser() {
		List<Employee> list = service.getStaff();
		for(Employee e : list)
			if(e.getUsername().equals(txUsername.getText()) &&
					e.getPassword().equals(txPassword.getText()) &&
					e.getIsAdmin()==1)
				return true;
		return false;
	}

    /**
	 * It shows the MainWindow window
	 * @param event
	 * @throws IOException if the fxmlFile doesn't exist
	 */
	private void showMainWindow() throws IOException {
        String fxmlFile = "/fxml/mainWindow.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode);
        scene.getStylesheets().addAll(this.getClass().getResource("/styles/JMetroLightTheme.css").toExternalForm());

        Stage stage = new Stage();

        stage.sizeToScene();

        stage.setTitle("Administración - Entrecine4");
        stage.setScene(scene);
        stage.show();
    }
}
