package com.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import com.example.models.BankAccount;
import com.example.models.PersonRegister;

public class AddAccountPopUpController {
    private PersonRegister personRegister;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField textFieldAccountNo;

    @FXML
    private ComboBox<String> comboBoxAccounts;

    public void setPersonRegister(PersonRegister personRegister) {
        this.personRegister = personRegister;
        populateComboBox();
        }

    private void showAlert(AlertType error, String message) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void populateComboBox() {
        if (personRegister != null) {
            ObservableList<String> accountNumbers = FXCollections.observableArrayList();
            for (BankAccount account : personRegister.getBankAccounts()) {
                accountNumbers.add("Account No: " + account.getAccountNumber());
            }
            comboBoxAccounts.setItems(accountNumbers);
        }
    }

    @FXML
    void handleAccountNo(ActionEvent event) {
        
    }

    @FXML
    void handleAddBtn(ActionEvent event) {
        String accountNoStr = textFieldAccountNo.getText();
        // BankAccount account = new BankAccount(accountNo, balance);
    }

    

}
