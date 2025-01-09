package com.example;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.controllers.MainViewController;

import com.example.models.PersonRegister;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create an instance of the PersonRegister class which will be used to store
        // Persons
        PersonRegister personRegister = new PersonRegister();
        URL url = getClass().getResource("/fxml/MainView.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Scene scene = new Scene(fxmlLoader.load());
        /*
         * After fxmlLoader.load() has been called, the controller
         * can be retrieved from the FXMLLoader instance.
         */
        MainViewController controller = fxmlLoader.getController();
        /*
         * The ProjectRegister instance is passed to the controller.
         */
        controller.setPersonRegister(personRegister);
        // Create a scene with the main view root node and set it on the primary stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bank Management");
        primaryStage.show();
    }

}
