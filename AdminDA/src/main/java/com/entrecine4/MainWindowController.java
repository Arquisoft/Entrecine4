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
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainWindowController implements Initializable {
    @FXML
    private Button btGestionarPeliculas;
    @FXML
    private Button btGestionarSalas;
    @FXML
    private Button btGestionarPersonal;
    @FXML
    private Button btGestionarIncidencias;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    /**
	 * It shows the RoomsWindow window
	 * @param event
	 * @throws IOException if the fxmlFile doesn't exist
	 */
    @FXML
    public void showRoomsWindow(ActionEvent event) throws IOException {
        String fxmlFile = "/fxml/roomsWindow.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode);
        scene.getStylesheets().addAll(this.getClass().getResource("/styles/JMetroLightTheme.css").toExternalForm());
       
        Stage stage = new Stage();

        stage.sizeToScene();

        stage.setTitle("Administración - Salas - Entrecine4");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
	 * It shows the IncidencesWindow window
	 * @param event
	 * @throws IOException if the fxmlFile doesn't exist
	 */
    @FXML
    public void showIncidenceWindow(ActionEvent event) throws IOException {
        String fxmlFile = "/fxml/incidenceWindow.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode);
        scene.getStylesheets().addAll(this.getClass().getResource("/styles/JMetroLightTheme.css").toExternalForm());
       
        Stage stage = new Stage();

        stage.sizeToScene();

        stage.setTitle("Administración - Incidencias - Entrecine4");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
	 * It shows the MoviesWindow window
	 * @param event
	 * @throws IOException if the fxmlFile doesn't exist
	 */
    @FXML
    public void showMoviesWindow(ActionEvent event) throws IOException {
        String fxmlFile = "/fxml/moviesWindow.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode);
        scene.getStylesheets().addAll(this.getClass().getResource("/styles/JMetroLightTheme.css").toExternalForm());
       
        Stage stage = new Stage();

        stage.sizeToScene();

        stage.setTitle("Administración - Películas - Entrecine4");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
	 * It shows the StaffWindow window
	 * @param event
	 * @throws IOException if the fxmlFile doesn't exist
	 */
    @FXML
    public void showStaffWindow(ActionEvent event) throws IOException {
        String fxmlFile = "/fxml/staffWindow.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode);
        scene.getStylesheets().addAll(this.getClass().getResource("/styles/JMetroLightTheme.css").toExternalForm());
       
        Stage stage = new Stage();

        stage.sizeToScene();

        stage.setTitle("Administración - Personal - Entrecine4");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
	 * It shows the SessionsWindow window
	 * @param event
	 * @throws IOException if the fxmlFile doesn't exist
	 */
    @FXML
    public void showSessionsWindow(ActionEvent event) throws IOException {
        String fxmlFile = "/fxml/sessionsWindow.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode);
        scene.getStylesheets().addAll(this.getClass().getResource("/styles/JMetroLightTheme.css").toExternalForm());
       
        Stage stage = new Stage();
        
        stage.sizeToScene();

        stage.setTitle("Administración - Sesiones - Entrecine4");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
	 * Closes the application
	 * @param event
	 */
    @FXML
    public void exit(ActionEvent event) {
    	((Stage) btGestionarIncidencias.getScene().getWindow()).close();
    }
}
