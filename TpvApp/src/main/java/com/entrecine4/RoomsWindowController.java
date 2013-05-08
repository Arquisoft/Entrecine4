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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Room;

import com.entrecine4.business.RoomService;
import com.entrecine4.infraestructure.Factories;

public class RoomsWindowController implements Initializable {

	private RoomService service = Factories.services.createRoomService();
	@FXML
	private Button btEditar;
	@FXML
	private Button btGuardar;
	@FXML
	private Button btDelete;
	@FXML
	private TextField txRows;
	@FXML
	private TextField txColumns;
	@FXML
	private ListView<Room> listSalas;
	private boolean newRoom = false;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btEditar.setDisable(true);
		ObservableList<Room> items = FXCollections.observableArrayList(service
				.getRooms());
		listSalas.setItems(items);
		listSalas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Room r = listSalas.getSelectionModel().getSelectedItem();
				txRows.setText(String.valueOf(r.getRows()));
				txColumns.setText(String.valueOf(r.getColumns()));
				putEditables(false);
				btEditar.setDisable(false);
				btGuardar.setDisable(true);
				btDelete.setDisable(false);
			}
		});
	}

	/**
	 * This method is called when btNuevo is pressed
	 * It makes all changes in order to add new rooms
	 * @param event
	 */
	@FXML
	public void newRoom(ActionEvent event) {
		newRoom = true;
		putEditables(true);
		eraseFieldsContent();
		btEditar.setDisable(true);
		btGuardar.setDisable(false);
		btDelete.setDisable(true);
	}
	
	/**
	 * This method is called when btEditar is pressed
	 * It makes all changes in order to edit the selected room
	 * @param event
	 */
	@FXML
	public void editRoom(ActionEvent event) {
		btEditar.setDisable(true);
		btGuardar.setDisable(false);
		conmuteFields();
	}

	/**
	 * This method is called when btGuardar is pressed
	 * It makes all changes in order to save a room
	 * @param event
	 */
	@FXML
	public void saveRoom(ActionEvent event) {
		if (validateFields()) {
			Room r;
			if (newRoom) {
				r = new Room();
				listSalas.getItems().add(r);
			} else {
				r = listSalas.getSelectionModel().getSelectedItem();
			}
			r.setRows(Integer.valueOf(txRows.getText()));
			r.setColumns(Integer.valueOf(txColumns.getText()));

			if (newRoom) {
				service.saveRoom(r);
				newRoom = false;
			} else
				service.updateRoom(r);
			btGuardar.setDisable(true);
			btEditar.setDisable(false);
			conmuteFields();
			updateList();
		}
	}

	/**
	 * This method is called when btDelete is pressed
	 * It makes all changes in order to delete a room
	 * @param event
	 */
	@FXML
	public void deleteRoom(ActionEvent event) {
		eraseFieldsContent();
		Room r = listSalas.getSelectionModel().getSelectedItem();
		service.deleteRoom(r);
		listSalas.getItems().remove(r);
		btDelete.setDisable(true);
		btEditar.setDisable(true);
		updateList();
	}

	/**
	 * This method is called when btHecho is pressed
	 * Close the current window
	 * @param event
	 */
	@FXML
	public void done(ActionEvent event) {
		((Stage) txColumns.getScene().getWindow()).close(); // close current
															// window
	}

	/**
	 * Commute the disable property of the fields
	 */
	private void conmuteFields() {
		txColumns.setEditable(!txColumns.isEditable());
		txRows.setEditable(!txRows.isEditable());
	}

	/**
	 * This method erases the content of the fields
	 */
	private void eraseFieldsContent() {
		txRows.setText("");
		txColumns.setText("");
	}

	/**
	 * It validates if the inputs are OK
	 * @return true if are OK, false otherwise
	 */
	private boolean validateFields() {
		if (txRows.getText().equals("") || txColumns.getText().equals(""))
			return false;
		try {
			Integer.parseInt(txRows.getText());
			Integer.parseInt(txColumns.getText());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Set to 'b' the following fields
	 * @param b
	 */
	private void putEditables(boolean b) {
		txRows.setEditable(b);
		txColumns.setEditable(b);
	}

	/**
	 * It updates the incidences list
	 */
	private void updateList() {
		listSalas
				.setItems(FXCollections.observableArrayList(service.getRooms()));
	}

}
