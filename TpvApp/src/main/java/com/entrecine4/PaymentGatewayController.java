package com.entrecine4;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.SessionState;

import com.entrecine4.infraestructure.Factories;

/**
 * FXML Controller class
 *
 * @author Familiar
 */
public class PaymentGatewayController implements Initializable {
    @FXML
    private AnchorPane mainWrapper;
    @FXML
    private Label lbTitle;
    @FXML
    private AnchorPane wrapper;
    @FXML
    private Label lbType;
    @FXML
    private Font x2;
    @FXML
    private Label lbNum;
    @FXML
    private TextField txtNumber;
    @FXML
    private Label lbCode;
    @FXML
    private TextField txtCode;
    @FXML
    private Label lbDate;
    @FXML
    private TextField txtDate;
    @FXML
    private Button btPay;
    @FXML
    private Button btClose;
    @FXML
    private ComboBox<String> comboType;
    
    private String type, number, securityCode, expirationDate;
    static int row, column;
    static long room;
    static long session;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }
    
    /**
     * It shows the MainWindow window
     * @param event
     * @throws IOException if the fxmlFile doesn't exist
     */
    private void showMainWindow() throws IOException
    {
    	String fxmlFile = "/fxml/mainWindow.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode);
        scene.getStylesheets().addAll(this.getClass()
        		.getResource("/styles/JMetroLightTheme.css").toExternalForm());

        ((Stage)txtCode.getScene().getWindow()).setScene(scene);
    }
    
    @FXML
    private void chooseType(ActionEvent event) 
    {
    	type=comboType.getValue();
    }
    
    @FXML
    private void pay(ActionEvent event) throws IOException 
    {
    	if(number==null || type==null || securityCode==null || expirationDate==null)
    		return;
    	if(Factories.services.createReservationService()
    			.goToPaymentGategay(number, type, securityCode, expirationDate));
    	{	
    		//insert sessionstate
    		//new SessionState(room, row, column, new Date(), session);
    		showMainWindow();
    	}
    }
    
    @FXML
    private void close(ActionEvent event) throws IOException 
    {
	    showMainWindow();
    }
}
