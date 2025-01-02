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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import com.example.models.BankAccount;
import com.example.models.Person;
import com.example.models.PersonRegister;

public class AddAccountPopUpController {
    private PersonRegister personRegister;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField textFieldAccountNo;

    @FXML
    private ComboBox<String> comboBoxAccounts;

    @FXML
    private TableView<Person> tableViewPersons;

    @FXML
    private TableColumn<Person, String> tableName;

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
        String accountNo = comboBoxAccounts.getSelectionModel().getSelectedItem();
        if (accountNo == null) {
            showAlert(AlertType.ERROR, "Please select an account number.");
            return;
        }

        // BankAccount account = new BankAccount(accountNo, balance);
    }

}
