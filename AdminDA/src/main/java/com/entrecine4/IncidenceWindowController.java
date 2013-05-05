package com.entrecine4;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.Incidence;
import models.Session;

import com.entrecine4.business.IncidenceService;
import com.entrecine4.infraestructure.Factories;

/**
 * FXML Controller class
 * 
 * @author Dani
 */
public class IncidenceWindowController implements Initializable {

	private IncidenceService service = Factories.services
			.createIncidenceService();
	@FXML
	private AnchorPane pnSession;
	@FXML
	private ListView<Incidence> listIncidences;
	@FXML
	private Font x1;
	@FXML
	private TextField txFecha;
	@FXML
	private TextField txSala;
	@FXML
	private TextField txSesion;
	@FXML
	private Button btElegirSesion;
	@FXML
	private TextArea txDescripcion;
	@FXML
	private Button btNueva;
	@FXML
	private Insets x2;
	@FXML
	private Button btEditar;
	@FXML
	private Button btGuardar;
	@FXML
	private Button btDelete;
	@FXML
	private Button btToday;
	@FXML
	private Button btHecho;
	private boolean newIncidence = false;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btEditar.setDisable(true);
		ObservableList<Incidence> items = FXCollections
				.observableArrayList(service.getIncidences());
		listIncidences.setItems(items);
		listIncidences.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Incidence i = listIncidences.getSelectionModel()
						.getSelectedItem();
				txFecha.setText(String.valueOf(i.getDay()));
				txDescripcion.setText(i.getDescription());
				txSesion.setText(String.valueOf(i.getSessionId()));
				txSala.setText(String.valueOf(i.getRoomId()));
				putEditables(false);
				btEditar.setDisable(false);
				btGuardar.setDisable(true);
				btDelete.setDisable(false);
			}
		});
	}

	private void putEditables(boolean b) {
		txDescripcion.setEditable(b);
		txFecha.setEditable(b);
		btElegirSesion.setDisable(!b);
		btToday.setDisable(!b);
	}

	@FXML
	private void newIncidence(ActionEvent event) {
		newIncidence = true;
		putEditables(true);
		eraseFieldsContent();
		btEditar.setDisable(true);
		btGuardar.setDisable(false);
		btDelete.setDisable(true);
	}

	@FXML
	private void editIncidence(ActionEvent event) {
		btEditar.setDisable(true);
		btGuardar.setDisable(false);
		conmuteFields();
	}

	@FXML
	private void saveIncidence(ActionEvent event) {
		if (validateFields()) {
			Incidence i;
			if (newIncidence) {
				i = new Incidence();
				listIncidences.getItems().add(i);
			} else {
				i = listIncidences.getSelectionModel().getSelectedItem();
			}

			i.setRoomId(Long.parseLong(txSala.getText()));
			i.setDay(Date.valueOf(txFecha.getText()));
			i.setDescription(txDescripcion.getText());
			i.setSessionId(Long.parseLong(txSesion.getText()));

			if (newIncidence) {
				service.saveIncidence(i);
				newIncidence = false;
			} else
				service.updateIncidence(i);

			btGuardar.setDisable(true);
			btEditar.setDisable(false);
			conmuteFields();
			eraseFieldsContent();
			updateList();
		}
	}

	@FXML
	private void deleteIncidence(ActionEvent event) {
		eraseFieldsContent();
		Incidence i = listIncidences.getSelectionModel().getSelectedItem();
		service.deleteIncidence(i);
		listIncidences.getItems().remove(i);
		btDelete.setDisable(true);
		btEditar.setDisable(true);
		updateList();
	}

	@FXML
	private void done(ActionEvent event) {
		((Stage) txDescripcion.getScene().getWindow()).close(); // close current
																// window
	}

	@FXML
	private void showPickSessionWindow(ActionEvent event) throws IOException {
		String fxmlFile = "/fxml/pickSessionWindow.fxml";
		FXMLLoader loader = new FXMLLoader();
		Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(
				fxmlFile));
		rootNode.setUserData(this);

		Scene scene = new Scene(rootNode);
		scene.getStylesheets().addAll(
				this.getClass().getResource("/styles/JMetroLightTheme.css")
						.toExternalForm());

		Stage stage = new Stage();

		stage.sizeToScene();

		stage.setTitle("Administración - Escoge sesión - Entrecine4");
		stage.setScene(scene);
		stage.show();
	}

	private void eraseFieldsContent() {
		txDescripcion.setText("");
		txFecha.setText("");
		txSesion.setText("");
		txSala.setText("");
	}

	private void conmuteFields() {
		txDescripcion.setEditable(!txDescripcion.isEditable());
		txFecha.setEditable(!txFecha.isEditable());
		btElegirSesion.setDisable(!btElegirSesion.isDisable());
		btToday.setDisable(!btToday.isDisable());
	}

	private boolean validateFields() {
		if (txDescripcion.getText().equals("") || txFecha.getText().equals("")
				|| txSesion.getText().equals(""))
			return false;
		try {
			Date.valueOf(txFecha.getText());
		} catch (NumberFormatException e) {
			return false;
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	@FXML
	private void printTodayDate(ActionEvent e) {
		txFecha.setText(new Date(System.currentTimeMillis()).toString());
	}

	void setSession(Session s) {
		txSesion.setText(String.valueOf(s.getId()));
		txSala.setText(String.valueOf(s.getRoomId()));
	}

	private void updateList() {
		listIncidences.setItems(FXCollections.observableArrayList(service
				.getIncidences()));
	}
}
