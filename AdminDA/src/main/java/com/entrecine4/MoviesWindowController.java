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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.Movie;

import com.entrecine4.business.MoviesService;
import com.entrecine4.infraestructure.Factories;

public class MoviesWindowController implements Initializable {

	private MoviesService service = Factories.services.createMoviesService();
	@FXML
	private Label lbTitulo;
	@FXML
	private ListView<Movie> listPeliculas;
	@FXML
	private Label lbTitle;
	@FXML
	private TextField txTitle;
	@FXML
	private TextField txGenre;
	@FXML
	private TextField txImagen;
	@FXML
	private Font x1;
	@FXML
	private Label lbSynopsis;
	@FXML
	private TextArea txSynopsis;
	@FXML
	private Label lbMorningPrice;
	@FXML
	private TextField txMorningPrice;
	@FXML
	private TextField txDailyPrice;
	@FXML
	private TextField txNightPrice;
	@FXML
	private Button btEditar;
	@FXML
	private Button btGuardar;
	@FXML
	private Button btDelete;
	private boolean newMovie = false;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btEditar.setDisable(true);
		ObservableList<Movie> items = FXCollections.observableArrayList(service
				.getMovies());
		listPeliculas.setItems(items);
		listPeliculas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Movie m = listPeliculas.getSelectionModel().getSelectedItem();
				txTitle.setText(m.getName());
				txSynopsis.setText(m.getSynopsis());
				txGenre.setText(m.getGenre());
				txImagen.setText(m.getImgPath());
				txMorningPrice.setText(String.valueOf(m.getMorningPrice()));
				txDailyPrice.setText(String.valueOf(m.getDailyPrice()));
				txNightPrice.setText(String.valueOf(m.getNightPrice()));
				putEditables(false);
				btEditar.setDisable(false);
				btGuardar.setDisable(true);
				btDelete.setDisable(false);
			}
		});
	}

	/**
	 * Set to 'b' the following fields
	 * 
	 * @param b
	 */
	private void putEditables(boolean b) {
		txMorningPrice.setEditable(b);
		txSynopsis.setEditable(b);
		txTitle.setEditable(b);
		txNightPrice.setEditable(b);
		txDailyPrice.setEditable(b);
		txGenre.setEditable(b);
		txImagen.setEditable(b);
	}

	/**
	 * This method is called when btEditar is pressed It makes all changes in
	 * order to edit the selected movie
	 * 
	 * @param event
	 */
	@FXML
	public void editMovie(ActionEvent e) {
		btEditar.setDisable(true);
		btGuardar.setDisable(false);
		conmuteFields();
	}

	/**
	 * This method is called when btHecho is pressed Close the current window
	 * 
	 * @param event
	 */
	@FXML
	public void done(ActionEvent e) {
		((Stage) txMorningPrice.getScene().getWindow()).close(); // close
																	// current
																	// window
	}

	/**
	 * This method is called when btGuardar is pressed It makes all changes in
	 * order to save a movie
	 * 
	 * @param event
	 */
	@FXML
	public void saveMovie(ActionEvent e) {
		if (validateFields()) {
			Movie m;
			if (newMovie) {
				m = new Movie();
				listPeliculas.getItems().add(m);
			} else {
				m = listPeliculas.getSelectionModel().getSelectedItem();
			}
			m.setName(txTitle.getText());
			m.setSynopsis(txSynopsis.getText());
			m.setMorningPrice(Double.parseDouble(txMorningPrice.getText()));
			m.setNightPrice(Double.parseDouble(txNightPrice.getText()));
			m.setDailyPrice(Double.parseDouble(txDailyPrice.getText()));
			m.setGenre(txGenre.getText());
			m.setImgPath(txImagen.getText());

			if (newMovie) {
				service.saveMovie(m);
				newMovie = false;
			} else
				service.updateMovie(m);

			btGuardar.setDisable(true);
			btEditar.setDisable(false);
			conmuteFields();
			updateList();
		}
	}

	/**
	 * Conmute the disable property of the fields
	 */
	private void conmuteFields() {
		txMorningPrice.setEditable(!txMorningPrice.isEditable());
		txSynopsis.setEditable(!txSynopsis.isEditable());
		txTitle.setEditable(!txTitle.isEditable());
		txNightPrice.setEditable(!txTitle.isEditable());
		txDailyPrice.setEditable(!txTitle.isEditable());
		txGenre.setEditable(!txGenre.isEditable());
		txImagen.setEditable(!txImagen.isEditable());
	}

	/**
	 * This method is called when btNuevo is pressed It makes all changes in
	 * order to add new movies
	 * 
	 * @param event
	 */
	@FXML
	public void newMovie(ActionEvent e) {
		newMovie = true;
		putEditables(true);
		eraseFieldsContent();
		btEditar.setDisable(true);
		btGuardar.setDisable(false);
		btDelete.setDisable(true);
	}

	/**
	 * This method is called when btDelete is pressed It makes all changes in
	 * order to delete a movie
	 * 
	 * @param event
	 */
	@FXML
	public void deleteMovie(ActionEvent e) {
		eraseFieldsContent();
		Movie m = listPeliculas.getSelectionModel().getSelectedItem();
		service.deleteMovie(m);
		listPeliculas.getItems().remove(m);
		btDelete.setDisable(true);
		btEditar.setDisable(true);
		updateList();
	}

	/**
	 * This method erases the content of the fields
	 */
	private void eraseFieldsContent() {
		txMorningPrice.setText("");
		txSynopsis.setText("");
		txTitle.setText("");
		txNightPrice.setText("");
		txDailyPrice.setText("");
		txGenre.setText("");
		txImagen.setText("");
	}

	/**
	 * It validates if the inputs are OK
	 * 
	 * @return true if are OK, false otherwise
	 */
	private boolean validateFields() {
		if (txDailyPrice.getText().equals("")
				|| txNightPrice.getText().equals("")
				|| txMorningPrice.getText().equals("")
				|| txSynopsis.getText().equals("")
				|| txTitle.getText().equals("") 
				|| txGenre.getText().equals("")
				|| txImagen.getText().equals("")) {
			return false;
		}
		try {
			Double.parseDouble(txDailyPrice.getText());
			Double.parseDouble(txMorningPrice.getText());
			Double.parseDouble(txNightPrice.getText());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * It updates the movies list
	 */
	private void updateList() {
		listPeliculas.setItems(FXCollections.observableArrayList(service
				.getMovies()));
	}
}
