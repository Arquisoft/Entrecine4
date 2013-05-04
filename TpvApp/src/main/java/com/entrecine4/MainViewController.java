/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrecine4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private TabPane rooms;
            
    @FXML
    private ToggleGroup group = new ToggleGroup();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeButtons();
        initializeList();
        initializeTabs(1);
    }
    
    private void initializeTabs(int numberOfTabs){
        for(int i=0; i<numberOfTabs; i++ ){
            Tab tab = new Tab();
            tab.setText("Sala "+i+1);
            tab.setContent(initializeRoomPanels(10, 10));
            rooms.getTabs().add(tab);
        }
    }

    private GridPane initializeRoomPanels(int rows, int columns) {
      
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
        final Button btn = new Button();
        btn.setText(i+","+j);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(btn.getText());
            }
        });
                  pane.add(btn, i, j);
            }
        }
        
        return pane;
    }

    private void initializeButtons() {
        rb12.setToggleGroup(group);
        rb12.setSelected(true);
        rb17.setToggleGroup(group);
        rb20.setToggleGroup(group);
        rb22.setToggleGroup(group);
    }

    @SuppressWarnings("unchecked")
	private void initializeList() {
        ObservableList<String> items = FXCollections.observableArrayList(
                "Espartaco", "Avatar", "American History X", "El padrino");
        moviesList.setItems(items);


        moviesList.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov,
                    String old_val, String new_val) {
                System.out.println(new_val);
            }
        });
    }
    
    @FXML
    private void logout() throws IOException {
       ((Stage) rb12.getScene().getWindow()).close(); //close current window
        Parent rootNode = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void buy() throws IOException {
        ((Stage) rb12.getScene().getWindow()).close(); //close current window
        Parent rootNode = FXMLLoader.load(getClass().getResource("/fxml/ConfirmationView.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }
}
