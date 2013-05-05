package com.entrecine4;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Session;

import com.entrecine4.business.SessionService;
import com.entrecine4.infraestructure.Factories;


public class PickSessionWindowController implements Initializable {

	private SessionService service = Factories.services.createSessionService();
	@FXML
	private ListView<Session> listSession;
	@FXML
	private Button btAceptar;
	@FXML
	private Button btCancelar;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		ObservableList<Session> items = FXCollections
				.observableArrayList(service.getSessions());
		listSession.setItems(items);
		listSession.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				btAceptar.setDisable(false);
			}
		});
	}

	/**
	 * It puts the session in the previous window and closes itself
	 * @param event
	 */
	@FXML
	private void accept(ActionEvent event) {
		Session s = listSession.getSelectionModel().getSelectedItem();
		IncidenceWindowController c = (IncidenceWindowController) listSession
				.getScene().getRoot().getUserData();
		c.setSession(s);
		((Stage) listSession.getScene().getWindow()).close(); // close current
																// window

	}

	/**
	 * This method closes the window
	 * @param event
	 */
	@FXML
	private void cancel(ActionEvent event) {
		((Stage) listSession.getScene().getWindow()).close(); // close current
																// window
	}
}
