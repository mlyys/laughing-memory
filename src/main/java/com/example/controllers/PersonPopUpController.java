package com.example.controllers;

import com.example.models.BankAccount;
import com.example.models.Person;
import com.example.models.PersonRegister;


import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.example.models.PersonRegister;

public class PersonPopUpController {
    private PersonRegister personRegister;
    @FXML
    private Button btnAdd;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textfieldAge;

    @FXML
    private TextField textfieldName;

    public void setPersonRegister(PersonRegister personRegister) {
        this.personRegister = personRegister;
    }
    @FXML
    public void initialize() {
        // Test alert to ensure it works
        System.out.println("hihi");
        Platform.runLater(() -> showAlert("Test Alert", "This is a test alert to ensure alerts are working."));
    }

    @FXML
    void handleBtnAdd(ActionEvent event) {
        String name = textfieldName.getText();
        String age = textfieldAge.getText();
        String id = textFieldID.getText();
        if (validAge(age) && validID(id) && validName(name)) {
            System.out.println("HELLO");
            int validAge = Integer.parseInt(age);
            Person person = new Person(id, name, validAge);
            BankAccount account = new BankAccount(null, 0);
        } else {
            System.out.println("HELLO");
            showAlert("Invalid input", "Please enter valid input.");
        }
        System.out.println("HELLO");
        }

       
    

    @FXML
    void handleTextFieldAge(ActionEvent event) {
    }

    private boolean validAge(String stringAge) {
        if (stringAge != null) {
            try {
                int age = Integer.parseInt(stringAge);
                return age >= 18;
            } catch (NumberFormatException e) {
                showAlert("Invalid age", "Invalid age. Person must be over 18.");
                return false;
            }
        }
            return false;
    }
    @FXML
    void testAlert() {
        showAlert("Test Alert", "This is a test alert.");
    }

    @FXML
    void handleTextFieldID(ActionEvent event) {

    }

    private boolean validID(String stringID) {
        if (stringID != null) {
            if (stringID.matches("\\d+")) {
                return true;
            } else {
                showAlert("Invalid ID", "Invalid ID. ID must only contain digits.");
                return false;
            }
        }
        return false;
    }

    @FXML
    void handleTextFieldName(ActionEvent event) {

    }

    boolean validName(String stringName) {
        if (stringName != null) {
           if  (stringName.matches("[a-zA-Z]+")) {
            if (stringName.length() >= 2) {
                return true;
            }
           } else {
            showAlert("Invalid name", "Name must contain atleast 2 letters.");
            return false;
        }
        }  else {
            showAlert("Invalid name", "Name must only contain letters.");
            return false;
           }
        return false;
    }

    private void showAlert(String title, String message) { // ALERT BOX
        Platform.runLater(() -> {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    });
}
}
