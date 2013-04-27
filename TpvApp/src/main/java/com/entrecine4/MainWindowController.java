package com.entrecine4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Arquisoft - Entrecine4
 */
public class MainWindowController implements Initializable {
    @FXML
    private Button btSeleccionarPelicula;
    @FXML
    private Label peliculaSeleccionada;
    @FXML
    private RadioButton rb12;
    @FXML
    private Font x1;
    @FXML
    private RadioButton rb17;
    @FXML
    private RadioButton rb20;
    @FXML
    private RadioButton rb22;
    @FXML
    private Button btContinuar;
    @FXML
    private Button btPelicula1;
    @FXML
    private Label lbTituloPelicula1;
    @FXML
    private Button btPelicula2;
    @FXML
    private Label lbTituloPelicula2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
