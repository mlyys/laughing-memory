package com.example.controllers;

import com.example.models.PersonRegister;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import com.example.models.PersonRegister;
public class ShowAccountPopUpController implements PersonRegisterAware{

    private PersonRegister personRegister;
    @FXML
    private Label labelAccount;

    @FXML
    private Label labelBalance;

    @FXML
    private Label labelOwner;
        private Parent rootNode;
    
    
        @Override
        public void setPersonRegister(PersonRegister personRegister) {
            this.personRegister = personRegister;
        }
    
    
        @Override
        public void setRootNode(Parent root) {
            this.rootNode = root;
    }

}
