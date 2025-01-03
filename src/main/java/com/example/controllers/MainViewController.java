package com.example.controllers;

import java.io.IOException;

import com.example.models.BankAccount;
import com.example.models.Person;
import com.example.models.PersonRegister;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController {
    private PersonRegister personRegister;

    @FXML
    private Parent root;
    @FXML
    private Button btnAddAccount;

    @FXML
    private Button btnAddPerson;

    @FXML
    private Button btnShowAccount;

    @FXML
    private Button btnRemovePerson;

    @FXML
    private Button btnDeposit;

    @FXML
    private Button btnWithdraw;

    @FXML
    private TableView<Person> tableViewPersons;

    @FXML
    private TableView<BankAccount> tableViewAccounts;

    @FXML
    private TableColumn<Person, Integer> tableAge;

    @FXML
    private TableColumn<Person, String> tableID;

    @FXML
    private TableColumn<Person, String> tableName;

    @FXML
    private TableColumn<BankAccount, String> tableAccountNo;

    @FXML
    private TableColumn<BankAccount, Double> tableBalance;

    @FXML
    private TextField textFieldSearch;

    @FXML
    private TextField textFieldAmount;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabAccountOwners;

    @FXML
    private Tab tabBankAccounts;

    public void setPersonRegister(PersonRegister personRegister) {
        this.personRegister = personRegister;
        if (tableViewPersons != null) {
            tableViewPersons.setItems(personRegister.getPersons());
        }
    }

    @FXML
    public void initialize() {
        tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableID.setCellValueFactory(new PropertyValueFactory<>("id"));

        tableAccountNo.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
        tableBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));

        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            // observable: the observablevalue that is being observed, oldTab: the tab that
            // was previously selected, newTab: the tab that is now selected
            if (newTab == tabAccountOwners) {
                populateAccountOwnersTable();
            } else if (newTab == tabBankAccounts) {
                populateBankAccountsTable();
            }
        });

        // Populate the initial tab (Account Owners)
        populateAccountOwnersTable();
        Person selectedPerson = tableViewPersons.getSelectionModel().getSelectedItem();

        if (selectedPerson == null) {
            btnAddAccount.disableProperty().bind(
                    tableViewPersons.getSelectionModel().selectedItemProperty().isNull());
        }

    }

    private void populateAccountOwnersTable() {
        if (personRegister != null && tableViewPersons != null) {
            tableViewPersons.setItems(personRegister.getPersons());
        }
    }

    private void populateBankAccountsTable() {
        if (personRegister != null && tableViewAccounts != null) {
            tableViewAccounts.setItems(personRegister.getBankAccounts());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void handleAddAccount(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AddAccountPopUpView.fxml"));
            Stage modalStage = new Stage();
            modalStage.setScene(new Scene(loader.load()));
            AddAccountPopUpController controller = loader.getController();
            controller.setPersonRegister(personRegister);
            modalStage.setTitle("Add Account");
            modalStage.initModality(Modality.APPLICATION_MODAL);
            Stage currentStage = (Stage) tableViewPersons.getScene().getWindow();
            modalStage.initOwner(currentStage);
            modalStage.showAndWait();
        } catch (IOException e) {
            String errorMessage = "An error occurred. Please try again.";
            showAlert("Error", errorMessage);
        }

    }

    @FXML
    void handleAddPerson(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PersonPopUpView.fxml"));
            Stage modalStage = new Stage();
            modalStage.setScene(new Scene(loader.load()));
            PersonPopUpController controller = loader.getController();
            controller.setPersonRegister(personRegister);
            modalStage.setTitle("Add Person");
            modalStage.initModality(Modality.APPLICATION_MODAL);
            Stage currentStage = (Stage) tableViewPersons.getScene().getWindow();
            modalStage.initOwner(currentStage);
            modalStage.showAndWait();
        } catch (IOException e) {
            String errorMessage = "An error occurred. Please try again.";
            showAlert("Error", errorMessage);
        }

    }

    @FXML
    void handleShowAccount(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShowAccountPopUpView.fxml"));
            Stage modalStage = new Stage();
            modalStage.setScene(new Scene(loader.load()));
            ShowAccountPopUpController controller = loader.getController();
            controller.setPersonRegister(personRegister);
            modalStage.setTitle("View Account");
            modalStage.initModality(Modality.APPLICATION_MODAL);
            Stage currentStage = (Stage) tableViewPersons.getScene().getWindow();
            modalStage.initOwner(currentStage);
            modalStage.showAndWait();
        } catch (IOException e) {
            String errorMessage = "An error occurred. Please try again.";
            showAlert("Error", errorMessage);
        }

    }

    @FXML
    void handleRemovePerson(ActionEvent event) {

    }

    @FXML
    void handleSearch(ActionEvent event) {

    }

    @FXML
    void handleTextFieldAmount(ActionEvent event) {

    }

    @FXML
    void handleWithdrawBtn(ActionEvent event) {

    }

    @FXML
    void handleDepositBtn(ActionEvent event) {

    }

}
