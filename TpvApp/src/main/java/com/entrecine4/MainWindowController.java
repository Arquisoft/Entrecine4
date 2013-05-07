package com.entrecine4;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.Movie;
import models.Room;
import models.Session;
import models.SessionState;

import com.entrecine4.business.MoviesService;
import com.entrecine4.business.RoomService;
import com.entrecine4.business.SessionService;
import com.entrecine4.business.SessionStateService;
import com.entrecine4.infraestructure.Factories;

public class MainWindowController implements Initializable {
    @FXML
    private Font x2;
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
    private TabPane roomTabPane;
    @FXML
    private Button btPelicula1;
    @FXML
    private Label lbTituloPelicula1;
    @FXML
    private Button btPelicula2;
    @FXML
    private Label lbTituloPelicula2;
    @FXML
    private Button btCerrarSesion;
    @FXML
    private ComboBox<String> comboMovies;

    private ToggleGroup toogleGroup;

    private MoviesService moviesService = Factories.services.createMoviesService();
    private SessionService sessionService = Factories.services.createSessionService();
    private RoomService roomService = Factories.services.createRoomService();
    private SessionStateService sessionStateService = Factories.services.createSessionStateService();
    private List<Session> sessions;
    private List<Room> rooms;
    private int currentRooms;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toogleGroup = new ToggleGroup();
        rb12.setToggleGroup(toogleGroup);
        rb17.setToggleGroup(toogleGroup);
        rb20.setToggleGroup(toogleGroup);
        rb22.setToggleGroup(toogleGroup);
        disableAllRadioButton();
        List<Movie> moviesList = moviesService.getMovies();
        for(Movie m : moviesList)
            comboMovies.getItems().add(m.getName());
    }    

    @FXML
    private void logoutPressed(ActionEvent event) throws IOException {
        ((Stage) btCerrarSesion.getScene().getWindow()).close();
        String fxmlFile = "/fxml/login.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode);
        scene.getStylesheets().addAll(this.getClass().getResource("/styles/JMetroLightTheme.css").toExternalForm());

        Stage stage = new Stage();

        stage.sizeToScene();

        stage.setTitle("Login - Entrecine4");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void chooseFilm(ActionEvent event) {
        removeRooms();
        disableAllRadioButton();
        Movie selectedMovie = moviesService.findByTitle(comboMovies.getValue());
        sessions = sessionService.findByDay(new Date());
        for(Session s : sessions) {
        	if(!s.getMovieTitle().equals(comboMovies.getValue()))
        		;
        	else if(s.getTime() == 12)
                rb12.setDisable(false);
            else if(s.getTime() == 17)
                rb17.setDisable(false);
            else if(s.getTime() == 20)
                rb20.setDisable(false);
            else if(s.getTime() == 22)
                rb22.setDisable(false);
        }
    }

    @FXML
    private void pressed12(ActionEvent event) {
        searchRoom(12);
    }

    @FXML
    private void pressed17(ActionEvent event) {
        searchRoom(17);
    }
    @FXML
    private void pressed20(ActionEvent event) {
        searchRoom(20);
    }
    @FXML
    private void pressed22(ActionEvent event) {
        searchRoom(22);
    }

    private void disableAllRadioButton() {
        rb12.setDisable(true);
        rb17.setDisable(true);
        rb20.setDisable(true);
        rb22.setDisable(true);
    }

    private void searchRoom(double session) {
        toogleGroup.getSelectedToggle().setSelected(false);
        removeRooms();
        sessions = sessionService.findByDayAndTime(new Date(), session);
        rooms = new ArrayList<Room>();
        currentRooms = 0;
        for(Session s : sessions) {
            Room room = roomService.findById(s.getRoomId());
            Tab tab = new Tab();
            tab.setText("Sala "+room.getId());
            tab.setContent(fillRoomPane(room, s));
            roomTabPane.getTabs().add(tab);
            currentRooms++;
        }
    }

    private void removeRooms() {
        roomTabPane.getTabs().remove(0,currentRooms); //remove all before enter new ones
        currentRooms = 0;
    }

    private ScrollPane fillRoomPane(final Room room, final Session session) {

        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);

        List<SessionState> sessionStates = sessionStateService
                .findBySession(session.getId());

        for (int column = 1; column < room.getColumns()+1; column++) {
            for (int row = 1; row < room.getRows()+1; row++) {
                final Button btn = new Button();
                btn.setText((row)+","+(column));
                if(reserved(sessionStates,row,column))
                    btn.setDisable(true);
                btn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        try {
                        	PaymentGatewayController.row=Integer.parseInt(btn.getText().split(",")[0]);
                        	PaymentGatewayController.column=Integer.parseInt(btn.getText().split(",")[1]);
                            PaymentGatewayController.room=room.getId();
                            PaymentGatewayController.session=session.getId();
                            PaymentGatewayController.price=getPrice(session);
							showPaymentWindow();
						} catch (IOException e) {
							e.printStackTrace();
						}
                    }

                });

                pane.add(btn, column, row);
            }
        }
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(pane);
        return scrollPane;
    }
    
    private boolean reserved(List<SessionState> sessionStates,int row, int column)
    {
    	for(SessionState sst: sessionStates)
    	{
    		if(sst.getRow()==row && sst.getColumn()==column)
    			return true;
    	}
    	return false;
    }
    
    /**
     * It shows the MainWindow window
     * @throws IOException if the fxmlFile doesn't exist
     */
    private void showPaymentWindow() throws IOException {
    	String fxmlFile = "/fxml/paymentGateway.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode);
        scene.getStylesheets().addAll(this.getClass().getResource("/styles/JMetroLightTheme.css").toExternalForm());

        ((Stage)btCerrarSesion.getScene().getWindow()).setScene(scene);
    }

    private double getPrice(Session session) {
        Movie movie = moviesService.findByTitle(comboMovies.getValue());
        return moviesService.getPrice(movie, session.getTime());
    }
}
