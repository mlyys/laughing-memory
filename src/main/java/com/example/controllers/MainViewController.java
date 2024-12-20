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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import com.example.models.PersonRegister;

public class MainViewController {
    private PersonRegister personRegister;
    @FXML
    private Button btnAddAccount;

    @FXML
    private Button btnAddPerson;

    @FXML
    private Button btnShowAccount;

    @FXML
    private Button btnRemovePerson;

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
    public void initialize() {
        personRegister = new PersonRegister();
        // Set sample data for testing
       
        tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableViewPersons.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        tableAccountNo.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
        tableBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        tableViewAccounts.setItems(personRegister.getBankAccounts());
        setPersonRegister(personRegister);
    }

    public void setPersonRegister(PersonRegister personRegister) {
        this.personRegister = personRegister;
       // tableViewPersons.setItems(personRegister.getPersons());
        //tableViewAccounts.setItems(personRegister.getBankAccounts());

        populatePersonTableView();
        populateAccountTableView();
    }

    private void populatePersonTableView() {
        tableViewPersons.getItems().clear();
        tableViewPersons.setItems(personRegister.getPersons());
    }

    private void populateAccountTableView() {
        tableViewAccounts.getItems().clear();
        tableViewAccounts.setItems(personRegister.getBankAccounts());
    }
/* 
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    */

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
    void handleShowAccount(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ShowAccountPopUpView.fxml"));
            Parent root = fxmlLoader.load();

            // create a new stage
            Stage stage = new Stage();
            stage.setTitle("View Account");

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

    @FXML
    void handleAddWithdraw(ActionEvent event) {

    }
}
