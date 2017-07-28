package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.academiadecodigo.bootcamp.utils.Security;

import static org.academiadecodigo.bootcamp.utils.Constants.EMAILREGEX;
import static org.academiadecodigo.bootcamp.utils.Constants.LOGINVIEW;

/**
 * Created by codecadet on 27/07/2017.
 */
public class RegisterController implements Controller{

    UserService userService;


    @FXML
    private Label nullFieldsWarning;

    @FXML
    private Label usernameTakenWarning;

    @FXML
    private Label invalidEmailWarning;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField emailField;

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
        onClickSignup(actionEvent);
    }

    public void onClickSignup(ActionEvent actionEvent) {
        if (nameField.getText() == null ||
                passwordField.getText() == null ||
                emailField.getText() == null){
            nullFieldsWarning.setVisible(true);
            return;
        }
        if(userService.findByName(nameField.getText())!= null){
            usernameTakenWarning.setVisible(true);
            return;
        }
        else if (!emailField.getText().matches(EMAILREGEX)){
            invalidEmailWarning.setVisible(true);
            return;
        }
        nullFieldsWarning.setVisible(false);
        invalidEmailWarning.setVisible(false);
        usernameTakenWarning.setVisible(false);
        userService.addUser(new User(nameField.getText(), Security.getHash(passwordField.getText()),emailField.getText()));
        Navigation.getInstance().loadScreen(LOGINVIEW);
    }
}
