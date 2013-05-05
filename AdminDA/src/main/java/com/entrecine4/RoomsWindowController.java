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

/**
 * FXML Controller class
 * 
 * @author Dani
 */
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

	@FXML
	public void newRoom(ActionEvent event) {
		newRoom = true;
		putEditables(true);
		eraseFieldsContent();
		btEditar.setDisable(true);
		btGuardar.setDisable(false);
		btDelete.setDisable(true);
	}

	@FXML
	public void editRoom(ActionEvent event) {
		btEditar.setDisable(true);
		btGuardar.setDisable(false);
		conmuteFields();
	}

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

	@FXML
	public void done(ActionEvent event) {
		((Stage) txColumns.getScene().getWindow()).close(); // close current
															// window
	}

	private void conmuteFields() {
		txColumns.setEditable(!txColumns.isEditable());
		txRows.setEditable(!txRows.isEditable());
	}

	private void eraseFieldsContent() {
		txRows.setText("");
		txColumns.setText("");
	}

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

	private void putEditables(boolean b) {
		txRows.setEditable(b);
		txColumns.setEditable(b);
	}

	private void updateList() {
		listSalas
				.setItems(FXCollections.observableArrayList(service.getRooms()));
	}

}
