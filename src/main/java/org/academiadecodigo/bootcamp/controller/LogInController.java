package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;

import static org.academiadecodigo.bootcamp.utils.Constants.INITVIEW;
import static org.academiadecodigo.bootcamp.utils.Constants.LETSGOVIEW;

/**
 * Created by codecadet on 27/07/2017.
 */
public class LogInController implements Controller {

    private UserService userService;

    private int counter = 0;

    @FXML
    private Label userNotFoundWarning;

    @FXML
    private Label nullFieldsWarning;

    @FXML
    private Label credentialsDontMatch;

    @FXML
    private TextField nameField;

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

    public void initialize() {
        userService = (UserService) ServiceRegistry.getInstance().getService(UserService.class.getSimpleName());
    }


    @Override
    public void setUserService(UserService userService) {

    }

    public void onKeyPressed(ActionEvent actionEvent) {
        onClickLogin(actionEvent);
    }

    public void onClickLogin(ActionEvent actionEvent) {

        if (nameField.getText() == null || passwordField.getText() == null) {
            System.out.println("dentro: " + nameField.getText());

            nullFieldsWarning.setVisible(true);
            counter++;
            if (counter == 3) {
                counter = 0;
                Navigation.getInstance().loadScreen(INITVIEW);
            }
            return;
        }

        if (userService.findByName(nameField.getText()) == null) {
            userNotFoundWarning.setVisible(true);
            counter++;
            if (counter == 3) {
                counter = 0;
                Navigation.getInstance().loadScreen(INITVIEW);
            }
            return;
        }

        if (!userService.authenticate(nameField.getText(), passwordField.getText())) {
            credentialsDontMatch.setVisible(true);
            System.out.println("Credentials don't match");
            counter++;
            if (counter == 3) {
                counter = 0;
                Navigation.getInstance().loadScreen(INITVIEW);
            }
            return;
        }
        credentialsDontMatch.setVisible(false);
        nullFieldsWarning.setVisible(false);
        userNotFoundWarning.setVisible(false);
        System.out.println("Access Granted");
        counter = 0;
        Navigation.getInstance().loadScreen(LETSGOVIEW);
    }
}
