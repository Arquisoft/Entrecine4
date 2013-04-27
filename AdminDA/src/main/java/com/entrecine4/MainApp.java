package com.entrecine4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {


    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
    	 String fxmlFile = "/fxml/login.fxml";
         FXMLLoader loader = new FXMLLoader();
         Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

         Scene scene = new Scene(rootNode);
         scene.getStylesheets().add("/styles/JMetroLightTheme.css");

         stage.setTitle("Login - Entrecine4");
         stage.setScene(scene);
         stage.show();
    }
}