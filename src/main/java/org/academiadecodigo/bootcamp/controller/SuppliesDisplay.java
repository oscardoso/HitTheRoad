package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.academiadecodigo.bootcamp.persistence.FileManager;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;

public class SuppliesDisplay implements Controller{

    @FXML
    private Button saveSupplies;

    @FXML
    private Button SuppliesNext;

    @FXML
    private TextField SuppliesDisplayText;
    private UserService userService;

    public void initialize() {
        userService = (UserService) ServiceRegistry.getInstance().getService(UserService.class.getSimpleName());
    }

    @FXML
    void SuppliesNextButtonPressed(ActionEvent event) {

    }


    //cuidado falta o user!!!!!
    @FXML
    void buttonSaveSuppliesPressed(ActionEvent event) {

        //FileManager.save(, SuppliesDisplayText.getText());
    }

    @Override
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

