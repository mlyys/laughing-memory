package com.example.controllers;

import com.example.models.PersonRegister;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.example.models.PersonRegister;
public class ManageAccountPopUpController {
    private PersonRegister personRegister;
    @FXML
    private Button btnDeposit;

    @FXML
    private Button btnWithdraw;

    @FXML
    private Label handleAccountOwner;

    @FXML
    private TextField textfieldAmount;

    
    public void setPersonRegister(PersonRegister personRegister) {
        this.personRegister = personRegister;
        }

    @FXML
    void handleAmount(ActionEvent event) {

    }

    @FXML
    void handleDepositBtn(ActionEvent event) {

    }

    @FXML
    void handleWithdrawBtn(ActionEvent event) {

    }

}
