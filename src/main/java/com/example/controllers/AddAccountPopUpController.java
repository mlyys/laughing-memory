package com.example.controllers;

import javafx.application.Platform;
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

    private Person selectedPerson;

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
                accountNumbers.add(account.getAccountNumber());
            }
            comboBoxAccounts.setItems(accountNumbers);
        }
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;

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

    private void showErrorMessage(String title, String message) {
        showAlert(title, message, Alert.AlertType.ERROR);
    }

    @FXML
    void handleAccountNo(ActionEvent event) {

    }

    @FXML
    void handleAddBtn(ActionEvent event) {
        String accountNo = comboBoxAccounts.getSelectionModel().getSelectedItem();
        if (accountNo == null) {
            showErrorMessage("Error", "Please select an account number.");
            return;
        }

        BankAccount account = personRegister.findAccount(accountNo);
        selectedPerson.addAccount(account);
        account.setPerson(selectedPerson);
        showSuccessMessage("Success", "Bank account successfully added.");

    }

}
