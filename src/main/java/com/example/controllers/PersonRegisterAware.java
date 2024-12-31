package com.example.controllers;

import com.example.models.PersonRegister;

import javafx.scene.Parent;

public interface PersonRegisterAware {
    void setPersonRegister(PersonRegister personRegister);
    void setRootNode(Parent root);
}