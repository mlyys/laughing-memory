package com.example.controllers;

import com.example.models.BankAccount;
import com.example.models.Person;
import com.example.models.PersonRegister;


import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.example.models.PersonRegister;

public class PersonPopUpController implements PersonRegisterAware{
    private PersonRegister personRegister;
    @FXML
    private Button btnAdd;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textfieldAge;

    @FXML
    private TextField textfieldName;
        private Parent rootNode;
    
        public void setPersonRegister(PersonRegister personRegister) {
            this.personRegister = personRegister;
        }
      
    
        @FXML
        void handleBtnAdd(ActionEvent event) {
            String name = textfieldName.getText();
            String age = textfieldAge.getText();
            String id = textFieldID.getText();
    
            String ageCheck = validAge(age);
            String idCheck = validID(id);
            String nameCheck = validName(name);
    
            if (ageCheck == null && idCheck == null && nameCheck == null) {
                int validAge = Integer.parseInt(age);
                Person person = new Person(id, name, validAge);
                BankAccount account = new BankAccount(null, 0);
                personRegister.addPerson(person);
                showSuccessMessage("Success", "Person added successfully.");
            } else {
                StringBuilder errorMessage = new StringBuilder("Invalid input:\n");
                if (ageCheck != null) {
                    errorMessage.append("- ").append(ageCheck).append("\n");
                }
                if (idCheck != null) {
                    errorMessage.append("- ").append(idCheck).append("\n");
                }
                if (nameCheck != null) {
                    errorMessage.append("- ").append(nameCheck).append("\n");
                }
                showErrorMessage("Error", errorMessage.toString());
            }
            if (personRegister == null) {
                showErrorMessage("Error", "PersonRegister is not initialized.");
                return;
            }
            }
    
           
        
    
        @FXML
        void handleTextFieldAge(ActionEvent event) {
        }
    
        private String validAge(String stringAge) {
            if (stringAge != null) {
               int age = Integer.parseInt(stringAge);
               if (age >= 18 && age <= 100) {
                    return null;
               }
               else {
                return "Age must be between 18 and 100.";
               }
            }
                return "Age cannot be empty.";
        }
    
        @FXML
        void handleTextFieldID(ActionEvent event) {
    
        }
    
        private String validID(String stringID) {
            if (stringID != null) {
                if (stringID.matches("\\d+")) {
                    return null;
                } else {
                    return "ID must only contain numbers.";
                }
            }
            return "ID cannot be empty.";
        }
    
        @FXML
        void handleTextFieldName(ActionEvent event) {
    
        }
    
        private String validName(String stringName) {
            if (stringName != null) {
               if  (stringName.matches("[a-zA-Z]+")) {
                if (stringName.length() >= 2) {
                    return null;
                }
               } else {
                return "Name must contain at least 2 letters";
            }
            }  else {
    
                return "Name must only contain letters.";
               }
            return "Name cannot be empty.";
        }
    
        private void showAlert(String title, String message, Alert.AlertType alertType) { // ALERT BOX
            Platform.runLater(() -> {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    
    }
    
    private void showSuccessMessage(String title, String message) {
        showAlert(title, message, Alert.AlertType.INFORMATION);
    }
    
    // Example usage for error message
    private void showErrorMessage(String title, String message) {
        showAlert(title, message, Alert.AlertType.ERROR);
    }
    
    
    @Override
    public void setRootNode(Parent root) {
        this.rootNode = root;
}
}
