package com.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.example.models.PersonRegister;

public class AccountPopUpController {
    private PersonRegister personRegister;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField textFieldAccountNo;

    @FXML
    private TextField textFieldBalance;

    public void setPersonRegister(PersonRegister personRegister) {
        this.personRegister = personRegister;
        }

    @FXML
    void handleAccountNo(ActionEvent event) {

    }

    @FXML
    void handleAddBtn(ActionEvent event) {

    }

    @FXML
    void handleBalance(ActionEvent event) {

    }
    

}
