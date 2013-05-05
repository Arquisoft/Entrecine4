package com.entrecine4;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.Employee;

import com.entrecine4.business.StaffService;
import com.entrecine4.infraestructure.Factories;

/**
 * FXML Controller class
 * 
 * @author Dani
 */
public class StaffWindowController implements Initializable {

	private StaffService service = Factories.services.createStaffService();
	@FXML
	private ListView<Employee> listaStaff;
	@FXML
	private TextField txUsuario;
	@FXML
	private Font x1;
	@FXML
	private PasswordField txPassword;
	@FXML
	private Button btNuevo;
	@FXML
	private Insets x2;
	@FXML
	private Button btEditar;
	@FXML
	private Button btGuardar;
	@FXML
	private Button btDelete;
	@FXML
	private CheckBox checkAdmin;
	private boolean newEmployee = false;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btEditar.setDisable(true);
		checkAdmin.setDisable(true);
		ObservableList<Employee> items = FXCollections
				.observableArrayList(service.getStaff());
		listaStaff.setItems(items);
		listaStaff.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Employee e = listaStaff.getSelectionModel().getSelectedItem();
				txUsuario.setText(String.valueOf(e.getUsername()));
				txPassword.setText(String.valueOf(e.getPassword()));
				checkAdmin.setIndeterminate(false);
				checkAdmin.setSelected(e.getIsAdmin() == 1);
				putEditables(false);
				btEditar.setDisable(false);
				btGuardar.setDisable(true);
				btDelete.setDisable(false);
			}
		});
	}

	@FXML
	private void newEmployee(ActionEvent event) {
		newEmployee = true;
		putEditables(true);
		eraseFieldsContent();
		btEditar.setDisable(true);
		btGuardar.setDisable(false);
		btDelete.setDisable(true);
	}

	@FXML
	private void editEmployee(ActionEvent event) {
		btEditar.setDisable(true);
		btGuardar.setDisable(false);
		conmuteFields();
	}

	@FXML
	private void saveEmployee(ActionEvent event) {
		if (validateFields()) {
			Employee e;
			if (newEmployee) {
				e = new Employee();
				listaStaff.getItems().add(e);
			} else {
				e = listaStaff.getSelectionModel().getSelectedItem();
			}
			e.setUsername(txUsuario.getText());
			e.setPassword(txPassword.getText());
			if (checkAdmin.isSelected())
				e.setIsAdmin(1);
			else
				e.setIsAdmin(0);
			if (newEmployee) {
				service.saveEmployee(e);
				newEmployee = false;
			} else
				service.updateEmployee(e);
			btGuardar.setDisable(true);
			btEditar.setDisable(false);
			conmuteFields();
			updateList();
		}
	}

	@FXML
	private void deleteEmployee(ActionEvent event) {
		eraseFieldsContent();
		Employee e = listaStaff.getSelectionModel().getSelectedItem();
		service.deleteEmployee(e);
		listaStaff.getItems().remove(e);
		btDelete.setDisable(true);
		btEditar.setDisable(true);
		updateList();
	}

	@FXML
	private void done(ActionEvent event) {
		((Stage) txPassword.getScene().getWindow()).close(); // close current
																// window
	}

	private void eraseFieldsContent() {
		txPassword.setText("");
		txUsuario.setText("");
		checkAdmin.setIndeterminate(true);
	}

	private void conmuteFields() {
		txPassword.setEditable(!txPassword.isEditable());
		txUsuario.setEditable(!txUsuario.isEditable());
		checkAdmin.setDisable(!checkAdmin.isDisable());
	}

	private boolean validateFields() {
		if (txUsuario.getText().equals("") || txPassword.getText().equals("")
				|| checkAdmin.isIndeterminate())
			return false;
		return true;
	}

	private void putEditables(boolean b) {
		txUsuario.setEditable(b);
		txPassword.setEditable(b);
		checkAdmin.setDisable(!b);
	}

	private void updateList() {
		listaStaff.setItems(FXCollections.observableArrayList(service
				.getStaff()));
	}
}
