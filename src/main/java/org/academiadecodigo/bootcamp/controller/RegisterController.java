package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.academiadecodigo.bootcamp.service.user.UserService;

/**
 * Created by codecadet on 27/07/2017.
 */
public class RegisterController implements Controller{


    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField nameField;

    @FXML
    private Button signUpBtn;

    @FXML
    private MenuItem backMenuItem;

    @FXML
    private Label sysMsg;

    @FXML
    void goBack(ActionEvent event) {
        Navigation.getInstance().back();
    }

    @FXML
    void onClick(ActionEvent event) {
        sysMsg.setVisible(false);
        if (usernameField ==  null){
            sysMsg.setText("Username Field can't be empty");
            sysMsg.setVisible(true);
            return;
        }
        else if (nameField == null){
            sysMsg.setText("Name Field can't be left empty");
            sysMsg.setVisible(true);
            return;
        }
        else if( emailField == null){
            sysMsg.setText("Email Field can't be empty");
            sysMsg.setVisible(true);
        }
        else if (passwordField == null){
            sysMsg.setText("Password field can't be left empty");
            sysMsg.setVisible(true);
            return;
        }
        else if (confirmPasswordField != passwordField){
            sysMsg.setText("Password doesn't match");
            sysMsg.setVisible(true);
            return;
        }
        else {
            usernameField.getText();
            nameField.getText();
            confirmPasswordField.getText();
            emailField.getText();
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
