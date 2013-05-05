/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecine4;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.entrecine4.business.MoviesService;
import com.entrecine4.business.RoomService;
import com.entrecine4.business.SessionService;
import com.entrecine4.business.SessionStateService;
import com.entrecine4.infraestructure.Factories;

import models.Movie;
import models.Room;
import models.Session;
import models.SessionState;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * 
 * @author Alberto
 */
public class MainViewController implements Initializable {

	@FXML
	private RadioButton rb12;
	@FXML
	private RadioButton rb17;
	@FXML
	private RadioButton rb20;
	@FXML
	private RadioButton rb22;
	@FXML
	private ListView moviesList;
	@FXML
	private TabPane roomsPane;
	@FXML
	private Label priceLabel;
	@FXML
	private ToggleGroup group = new ToggleGroup();

	private SessionStateService sessionStateService;
	private RoomService roomService;
	private SessionService sessionService;
	private MoviesService movieService;

	private List<Session> sessions; // day´s sessions
	private double currentTime; // current session hour selected
	private List<Session> currentSessions; // sessions for the current movie selected
	private long currentRoomId; //current room id selected
	private List<SessionState> reservations;
	private double moviePrice;
	private double price;
	private String movieTitle;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		//sessionService = Factories.services.createSessionService();
		//sessionStateService = Factories.services.createSessionStateService();
		//roomService = Factories.services.createRoomService();
		//movieService = Factories.services.createMoviesService();
		//sessions = sessionService.findByDay(new Date());
		reservations = new ArrayList<SessionState>();
		currentTime = Session.TWELVE;
		price = 0;
		priceLabel.setText(price+" €");
		initializeButtons();
		//fillList();
	}

	private void fillTabs() {

		List<Room> rooms = new ArrayList<Room>();

		for (Session s : currentSessions) {
			rooms.add(roomService.findById(s.getRoomId()));
		}

		for (int i=0; i<rooms.size(); i++) {
			final Tab tab = new Tab();
			tab.setText("Sala " + rooms.get(i).getId());
			tab.setId(String.valueOf(rooms.get(i).getId()));
			tab.setOnSelectionChanged(new EventHandler<Event>() {
		        public void handle(Event evt) {
		            if (tab.isSelected()) {
		              currentRoomId = Long.parseLong(tab.getId());
		              clearReservations();
		            }
		          }
		        });
			tab.setContent(fillRoomPane(rooms.get(i), i));
			roomsPane.getTabs().add(tab);
		}
	}

	private GridPane fillRoomPane(Room room, int k) {

		GridPane pane = new GridPane();
		pane.setVgap(5);
		pane.setHgap(5);

		List<SessionState> sessionStates = sessionStateService
				.findBySession(currentSessions.get(k).getId());

		for (int i = 0; i < room.getRows(); i++) {
			for (int j = 0; j < room.getColumns(); j++) {
				final Button btn = new Button();
				btn.setText("L");
				btn.setId(i+","+j);
				btn.setOnAction(new EventHandler<ActionEvent>() {
					String[] coordinates = btn.getId().split(",");
					int row = Integer.parseInt(coordinates[0]);
					int column = Integer.parseInt(coordinates[1]);
					long sessionId = findCurrentSession().getId();
					
					@Override
					public void handle(ActionEvent event) {
						
						if(btn.getText().equals("0")){	//Si queremos deshacer el marcado
							btn.setText("L"); //Marcamos como libre
							SessionState s = findReservation(row, column); //Buscamos la reserva
							sessionStateService.deleteSessionState(s); // Borramos la reserva
							reservations.remove(s);
							price -= moviePrice;
							priceLabel.setText(price+" €");
						}
						
						
						
						if(sessionStateService.checkFreeSeat(sessionId, currentRoomId, row, column)){
							SessionState ss = new SessionState(currentRoomId, row, column, new Date(), sessionId);
							sessionStateService.saveSessionState(ss);
							reservations.add(ss);
							price += moviePrice;
							priceLabel.setText(price+" €");
							btn.setText("O");
						}
						
						System.out.println(btn.getText());
					}
				});

				pane.add(btn, i, j);
			}
		}

		for (SessionState s : sessionStates) {
			Button btn = new Button();
			btn.setText("O");
			
			pane.add(btn, s.getRow(), s.getColumn());
		}

		return pane;
	}
	
	private Session findCurrentSession(){
		for(Session s : currentSessions){
			if(s.getRoomId() == currentRoomId)
				return s;
		}
		return null;
	}
	
	private SessionState findReservation(int row, int column){
		for(SessionState s : reservations){
			if(s.getRow() == row && s.getColumn() == column)
				return s;
		}
		return null;
	}

	private void initializeButtons() {
		rb12.setToggleGroup(group);
		rb17.setToggleGroup(group);
		rb20.setToggleGroup(group);
		rb22.setToggleGroup(group);
	}
	
	private void clearReservations(){
		price = 0;
		priceLabel.setText(price+" €");
		 for(SessionState s : reservations){
       	  sessionStateService.deleteSessionState(s);
         }
         reservations.clear();
	}

	@SuppressWarnings("unchecked")
	private void fillList() {
		ObservableList<String> items = FXCollections.observableArrayList();

		for (Session s : sessions) {
			if (s.getTime() == currentTime
					&& !items.contains(s.getMovieTitle())) {
				items.add(s.getMovieTitle());
			}
		}

		moviesList.setItems(items);

		moviesList.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<String>() {
					public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
						clearReservations();
						setMoviePrice(new_val);
						currentSessions.clear();
						for (Session s : sessions) {
							if (s.getTime() == currentTime && s.getMovieTitle().equals(new_val)) {
								movieTitle = new_val;
								currentSessions.add(s);
								fillTabs();
							}
						}
					}
				});
	}
	
	private void setMoviePrice(String title){
		Movie movie = movieService.findByTitle(title);
		
		if(currentTime == Session.TWELVE)
			moviePrice = movie.getMorningPrice();
		else if(currentTime == Session.SEVENTEEN)
			moviePrice = movie.getDailyPrice();
		else if(currentTime == Session.TWENTY)
			moviePrice = movie.getDailyPrice();
		else if(currentTime == Session.TWENTY_TWO)
			moviePrice = movie.getNightPrice();
	}
	
	@FXML
	private void logout() throws IOException {
		clearReservations();
		((Stage) rb12.getScene().getWindow()).close(); // close current window
		Parent rootNode = FXMLLoader.load(getClass().getResource(
				"/fxml/login.fxml"));

		Scene scene = new Scene(rootNode);

		Stage stage = new Stage();

		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void buy() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		
		((Stage) rb12.getScene().getWindow()).close(); // close current window
		Parent rootNode = FXMLLoader.load(getClass().getResource(
				"/fxml/ConfirmationView.fxml"));

		Scene scene = new Scene(rootNode);
		
		Stage stage = new Stage();
        ConfirmationViewController ctrl = (ConfirmationViewController) fxmlLoader.getController();
        ctrl.setReservations(reservations);
        ctrl.setHour(currentTime);
        ctrl.setPrice(price);
        ctrl.setMovie(movieTitle);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void rb12(){
		currentTime = Session.TWELVE;
		clearReservations();
		fillList();
		
	}
	
	@FXML
	private void rb17(){
		currentTime = Session.SEVENTEEN;
		clearReservations();
		fillList();
	}
	
	@FXML
	private void rb20(){
		currentTime = Session.TWENTY;
		clearReservations();
		fillList();
	}
	
	@FXML
	private void rb22(){
		currentTime = Session.TWENTY_TWO;
		clearReservations();
		fillList();
	}
}
