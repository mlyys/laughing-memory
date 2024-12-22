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

    public void setPersonRegister(PersonRegister personRegister) {
        this.personRegister = personRegister;
        tableViewPersons.setItems(personRegister.getPersons());
    }

    @FXML
    public void initialize() {
        tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableViewPersons.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
       // tableViewAccounts.setItems(personRegister.getBankAccounts());
        // Sample data setup
          personRegister = new PersonRegister();
          Person person1 = new Person("A001", "Anna", 30);
          person1.addAccount(new BankAccount("12345", 5000.0));
          person1.addAccount(new BankAccount("67890", 10000.0));
          
          Person person2 = new Person("J001", "John", 40);
          person2.addAccount(new BankAccount("54321", 7000.0));
  
          personRegister.addPerson(person1);
          personRegister.addPerson(person2);
        // Set sample data for testing
        setPersonRegister(personRegister);
       // tableViewPersons.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
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
