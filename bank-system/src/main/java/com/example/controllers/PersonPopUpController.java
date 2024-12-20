package com.example.controllers;

import com.example.models.PersonRegister;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.example.models.PersonRegister;
public class PersonPopUpController {
    private PersonRegister personRegister;
    @FXML
    private Button btnAdd;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textfieldAge;

    @FXML
    private TextField textfieldName;

    
    public void setPersonRegister(PersonRegister personRegister) {
        this.personRegister = personRegister;
        }

    @FXML
    void handleBtnAdd(ActionEvent event) {

    }

    @FXML
    void handleTextFieldAge(ActionEvent event) {

    }

    @FXML
    void handleTextFieldID(ActionEvent event) {

    }

    @FXML
    void handleTextFieldName(ActionEvent event) {

    }

}
