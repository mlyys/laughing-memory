package com.example.controllers;

import java.io.IOException;

import com.example.models.Person;
import com.example.models.PersonRegister;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.example.models.PersonRegister;

public class MainViewController {
    private PersonRegister personRegister;
    @FXML
    private Button btnAddAccount;

    @FXML
    private Button btnAddPerson;

    @FXML
    private Button btnManageAccount;

    @FXML
    private Button btnRemovePerson;

    @FXML
    private TableColumn<Person, Integer> tableAge;

    @FXML
    private TableColumn<Person, String> tableID;

    @FXML
    private TableColumn<Person, String> tableName;

    @FXML
    private TextField textFieldSearch;

    public void setPersonRegister(PersonRegister personRegister) {
        this.personRegister = personRegister;
    }

    @FXML
    void handleAddAccount(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AccountPopUpView.fxml"));
            Parent root = fxmlLoader.load();

            // create a new stage
            Stage stage = new Stage();
            stage.setTitle("Add Account");

            // set the scene for the stage
            stage.setScene(new Scene(root));
            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleAddPerson(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/PersonPopUpView.fxml"));
            Parent root = fxmlLoader.load();

            // create a new stage
            Stage stage = new Stage();
            stage.setTitle("Add Account");

            // set the scene for the stage
            stage.setScene(new Scene(root));
            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleManageAccount(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ManageAccountPopUpView.fxml"));
            Parent root = fxmlLoader.load();

            // create a new stage
            Stage stage = new Stage();
            stage.setTitle("Manage Account");

            // set the scene for the stage
            stage.setScene(new Scene(root));
            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleRemovePerson(ActionEvent event) {

    }

    @FXML
    void handleSearch(ActionEvent event) {

    }

}
