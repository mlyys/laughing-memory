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
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainViewController implements PersonRegisterAware {
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
        if (tableViewPersons != null) {
            tableViewPersons.setItems(personRegister.getPersons());
        }
    }


    public Parent getRoot() {
        return root;
    }
    @Override
    public void setRootNode(Parent root) {
        this.root = root;
    }



    @FXML
    public void initialize() {
        tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableID.setCellValueFactory(new PropertyValueFactory<>("id"));
       
      
         // Only initialize personRegister if it hasn't been set yet
         if (personRegister == null) {
            personRegister = new PersonRegister();
            setPersonRegister(personRegister);
        } else {
            // Ensure test data is loaded if personRegister is already set
            if (personRegister.getPersons().isEmpty()) {
                personRegister.addTestData();
            }
        }
        tableViewPersons.setItems(personRegister.getPersons());
        tableViewPersons.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AddAccountPopUpView.fxml"));
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
