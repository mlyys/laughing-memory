package com.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import com.example.models.BankAccount;
import com.example.models.PersonRegister;

public class AddAccountPopUpController implements PersonRegisterAware{
    private PersonRegister personRegister;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField textFieldAccountNo;

    @FXML
    private ComboBox<String> comboBoxAccounts;
    
        private Parent rootNode;
    
        @Override
        public void setPersonRegister(PersonRegister personRegister) {
            this.personRegister = personRegister;
            populateComboBox();
            }
    
        @FXML
        private void initialize() {
                // Ensure comboBoxAccounts is initialized
                if (comboBoxAccounts != null) {
                    populateComboBox();
                }
            }
    
    
        private void populateComboBox() {
            if (comboBoxAccounts != null && personRegister != null) {
                ObservableList<String> accountNumbers = FXCollections.observableArrayList();
                for (BankAccount account : personRegister.getBankAccounts()) {
                    accountNumbers.add("Account No: " + account.getAccountNumber());
                }
                comboBoxAccounts.setItems(accountNumbers);
            }
        }
    
        private void showAlert(AlertType error, String message) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
        @FXML
        void handleAccountNo(ActionEvent event) {
            
        }
    
        @FXML
        void handleAddBtn(ActionEvent event) {
            String accountNoStr = textFieldAccountNo.getText();
            // BankAccount account = new BankAccount(accountNo, balance);
        }
    
      
        @Override
        public void setRootNode(Parent root) {
            this.rootNode = root;
    }
    

}
