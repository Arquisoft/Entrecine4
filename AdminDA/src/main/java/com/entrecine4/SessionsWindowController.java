package com.entrecine4;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.Room;
import models.Session;

import com.entrecine4.business.RoomService;
import com.entrecine4.business.SessionService;
import com.entrecine4.infraestructure.Factories;

public class SessionsWindowController implements Initializable {

	private SessionService service = Factories.services.createSessionService();
	private RoomService serviceRooms = Factories.services.createRoomService();
	
	@FXML
	private ListView<Session> listSessions;
	@FXML
	private Button btNuevo;
	@FXML
	private Insets x1;
	@FXML
	private Button btEditar;
	@FXML
	private Button btGuardar;
	@FXML
	private Button btDelete;
	@FXML
	private Button btHecho;
	@FXML
	private TextField txFecha;
	@FXML
	private TextField txTituloPelicula;
	@FXML
	private Font x2;
	@FXML
	private Button btToday;
	@FXML
	private ComboBox<Long> cbSalas;
	@FXML
	private Label lbError;
	@FXML
	private ComboBox<Double> cbHorario;
	private boolean newSession = false;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btEditar.setDisable(true);
		populateCbs();
		ObservableList<Session> items = FXCollections.observableArrayList(service.getSessions());
		listSessions.setItems(items);
		listSessions.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Session s = listSessions.getSelectionModel().getSelectedItem();
				txFecha.setText(String.valueOf(s.getDay()));
				txTituloPelicula.setText(String.valueOf(s.getMovieTitle()));
				cbSalas.setValue(s.getRoomId());
				cbHorario.setValue(s.getTime());
				putEditables(false);
				lbError.setVisible(false);
				btEditar.setDisable(false);
				btGuardar.setDisable(true);
				btDelete.setDisable(false);
			}
		});
	}

	/**
	 * This method populates cb's
	 */
	private void populateCbs() {
		List<Long> roomsIds = new ArrayList<Long>();
		List<Room> rooms = serviceRooms.getRooms();
		for(Room r : rooms)
			roomsIds.add(r.getId());
		cbSalas.setItems(FXCollections.observableArrayList(roomsIds));

		List<Double> horarios = new ArrayList<Double>();
		horarios.add(new Double(12));
		horarios.add(new Double(17));
		horarios.add(new Double(20));
		horarios.add(new Double(22));
		cbHorario.setItems(FXCollections.observableArrayList(horarios));
	}

	/**
	 * Set to 'b' the following fields
	 * 
	 * @param b
	 */
	private void putEditables(boolean b) {
		txFecha.setEditable(b);
		txTituloPelicula.setEditable(b);
		cbHorario.setDisable(!b);
		cbSalas.setDisable(!b);
		btToday.setDisable(!b);
	}

	/**
	 * This method is called when btNuevo is pressed
	 * It makes all changes in order to add new sessions
	 * @param event
	 */
	@FXML
	private void newSession(ActionEvent event) {
		newSession = true;
		putEditables(true);
		eraseFieldsContent();
		lbError.setVisible(false);
		btEditar.setDisable(true);
		btGuardar.setDisable(false);
		btDelete.setDisable(true);
	}
	
	/**
	 * This method erases the content of the fields
	 */
	private void eraseFieldsContent() {
		txFecha.setText("");
		txTituloPelicula.setText("");
		cbHorario.setValue(null);
		cbSalas.setValue(null);
	}

	/**
	 * This method is called when btEditar is pressed
	 * It makes all changes in order to edit the selected session
	 * @param event
	 */
	@FXML
	private void editSession(ActionEvent event) {
		btEditar.setDisable(true);
		btGuardar.setDisable(false);
		conmuteFields();
	}

	/**
	 * Commute the disable property of the fields
	 */
	private void conmuteFields() {
		txFecha.setEditable(!txFecha.isEditable());
		txTituloPelicula.setEditable(!txTituloPelicula.isEditable());
		cbSalas.setDisable(!cbSalas.isDisable());
		btToday.setDisable(!btToday.isDisable());
		cbHorario.setDisable(!cbHorario.isDisable());
	}
	
	/**
	 * This method is called when btGuardar is pressed
	 * It makes all changes in order to save a room
	 * @param event
	 */
	@FXML
	private void saveSession(ActionEvent event) {
		if (validateFields()) {
			Session s;
			if (newSession) {
				s = new Session();
				listSessions.getItems().add(s);
			} else {
				s = listSessions.getSelectionModel().getSelectedItem();
			}

			s.setRoomId(cbSalas.getSelectionModel().getSelectedItem());
			s.setDay(Date.valueOf(txFecha.getText()));
			s.setMovieTitle(txTituloPelicula.getText());
			s.setTime(cbHorario.getSelectionModel().getSelectedItem());

			if (newSession) {
				service.saveSession(s);
				newSession = false;
			} else
				service.updateSession(s);

			btGuardar.setDisable(true);
			btEditar.setDisable(false);
			lbError.setVisible(false);
			conmuteFields();
			eraseFieldsContent();
			updateList();
		}
	}

	/**
	 * It updates the incidences list
	 */
	private void updateList() {
		listSessions
				.setItems(FXCollections.observableArrayList(service.getSessions()));
	}

	/**
	 * It validates if the inputs are OK
	 * @return true if are OK, false otherwise
	 */
	private boolean validateFields() {
		if (txFecha.getText().equals("") || txTituloPelicula.getText().equals(""))
			return false;
		if(cbHorario.getValue()==null || cbSalas.getValue()==null)
			return false;
		try {
			Date.valueOf(txFecha.getText());
		} catch (IllegalArgumentException e) {
			return false;
		}
		if(validateSession())
			return false;
		return true;
	}

	/**
	 * It validates if a room in a day and in an hour is empty
	 * @return true if not
	 */
	private boolean validateSession() {
		List<Session> list = service.findByDayAndTime(Date.valueOf(txFecha.getText()), cbHorario.getValue());
		for(Session s : list)
			if(s.getRoomId() == cbSalas.getValue()){
				lbError.setText("La sala "+s.getRoomId()+" ya está ocupada para el "+s.getDay()+" a las "+s.getTime()+": "+s.getMovieTitle()+".");
				lbError.setVisible(true);
				return true;
			}
		return false;
	}

	/**
	 * This method is called when btDelete is pressed
	 * It makes all changes in order to delete a session
	 * @param event
	 */
	@FXML
	private void deleteSession(ActionEvent event) {
		eraseFieldsContent();
		Session s = listSessions.getSelectionModel().getSelectedItem();
		service.deleteSession(s);
		listSessions.getItems().remove(s);
		btDelete.setDisable(true);
		btEditar.setDisable(true);
		lbError.setVisible(false);
		updateList();
	}

	/**
	 * This method is called when btHecho is pressed
	 * Close the current window
	 * @param event
	 */
	@FXML
	public void done(ActionEvent event) {
		((Stage) txFecha.getScene().getWindow()).close(); // close current
															// window
	}

	/**
	 * This method sets today's date into txFecha
	 * @param e
	 */
	@FXML
	private void printTodayDate(ActionEvent e) {
		txFecha.setText(new Date(System.currentTimeMillis()).toString());
	}
}
