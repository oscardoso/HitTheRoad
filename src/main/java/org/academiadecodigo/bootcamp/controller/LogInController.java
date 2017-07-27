package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.academiadecodigo.bootcamp.service.user.UserService;

/**
 * Created by codecadet on 27/07/2017.
 */
public class LogInController implements Controller{

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private MenuItem closeBtn;

    @FXML
    private MenuItem backMenuItem;


    @FXML
    void goBack(ActionEvent event) {
        Navigation.getInstance().back();

    }

    @FXML
    void onClick(ActionEvent event) {
        if (usernameField == null){

        }


    }

    @FXML
    void onClose(ActionEvent event) {

        System.exit(1);
    }


    @Override
    public void setUserService(UserService userService) {

    }
}
