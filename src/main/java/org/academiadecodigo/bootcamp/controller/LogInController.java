package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.user.UserService;

/**
 * Created by codecadet on 27/07/2017.
 */
public class LogInController implements Controller {

    private UserService userService;
    private final String LETSGO = "letsgo";
    private final String INTRO = "initView";
    private int counter = 0;

    @FXML
    private Label userNotFoundWarning;

    @FXML
    private Label nullFieldsWarning;

    @FXML
    private Label credentialsDontMatch;

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


    }

    @FXML
    void onClose(ActionEvent event) {

        System.exit(1);
    }


    @Override
    public void setUserService(UserService userService) {

    }

    public void onKeyPressed(ActionEvent actionEvent) {
        onClickLogin(actionEvent);
    }

    public void onClickLogin(ActionEvent actionEvent) {

        if (usernameField == null || passwordField == null) {
            nullFieldsWarning.setVisible(true);
            return;
        }

        if (userService.findByName(usernameField.getText()) == null) {
            userNotFoundWarning.setVisible(true);
            return;
        }

        if (!userService.authenticate(usernameField.getText(), passwordField.getText())) {
            credentialsDontMatch.setVisible(true);
            System.out.println("Credentials don't match");
            counter++;
            if (counter == 3) {
                counter = 0;
                Navigation.getInstance().loadScreen(INTRO);
            }
            return;
        }
        credentialsDontMatch.setVisible(false);
        nullFieldsWarning.setVisible(false);
        userNotFoundWarning.setVisible(false);
        System.out.println("Access Granted");
        counter = 0;
        Navigation.getInstance().loadScreen(LETSGO);
    }
}
