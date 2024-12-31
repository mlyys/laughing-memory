package com.example;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import com.example.controllers.AddAccountPopUpController;
import com.example.controllers.MainViewController;
import com.example.controllers.PersonPopUpController;
import com.example.controllers.PersonRegisterAware;
import com.example.controllers.ShowAccountPopUpController;
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
        // The location is relative to the root of the classpath (target/classes)
        // Load the MainView.fxml file and set the PersonRegister
        MainViewController mainViewController = loadFXMLWithController("/fxml/MainView.fxml", personRegister);
        // Load the PersonPopUp.fxml file and set the PersonRegister
        PersonPopUpController personPopUpController = loadFXMLWithController("/fxml/PersonPopUpView.fxml", personRegister);
         
        AddAccountPopUpController addAccountPopUpController = loadFXMLWithController("/fxml/AddAccountPopUpView.fxml", personRegister);

        ShowAccountPopUpController showAccountPopUpController = loadFXMLWithController("/fxml/ShowAccountPopUpView.fxml", personRegister);

        // Create a scene with the main view root node and set it on the primary stage
        Scene scene = new Scene(mainViewController.getRoot());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bank Management");
        primaryStage.show();
    }

    private <T> T loadFXMLWithController(String fxmlPath, PersonRegister personRegister) throws IOException {
        System.out.println("Loading FXML: " + fxmlPath); // Debug statement
        URL resource = getClass().getResource(fxmlPath);
        if (resource == null) {
            throw new IOException("FXML file not found: " + fxmlPath);
        }
    
        FXMLLoader loader = new FXMLLoader(resource);
    
        loader.setControllerFactory(controllerClass -> {
            try {
                Object controller = controllerClass.getDeclaredConstructor().newInstance();
                if (controller instanceof PersonRegisterAware) {
                    ((PersonRegisterAware) controller).setPersonRegister(personRegister);
                }
                return controller;
            } catch (Exception e) {
                throw new RuntimeException("Failed to instantiate controller for " + fxmlPath, e);
            }
        });
    
        Parent root = loader.load(); // Load the FXML and get the root node
        T controller = loader.getController(); // Get the controller
        
        if (controller instanceof PersonRegisterAware) { 
            ((PersonRegisterAware) controller).setRootNode(root); // Set root node if the controller supports it
        }
        
        return controller;
    }
    
    
    }
    

            /*Parent root = loader.load();
            T controller = loader.getController();
            if (controller instanceof PersonRegisterAware) {
                ((PersonRegisterAware) controller).setPersonRegister(personRegister);
            }
            return controller;
            */
    //}
