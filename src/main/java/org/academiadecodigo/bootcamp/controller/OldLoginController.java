package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.academiadecodigo.bootcamp.utils.Security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OldLoginController implements Controller{

    @FXML
    private Label email;

    @FXML
    private TextField userName;

    @FXML
    private TextField emailInputed;

    @FXML
    private PasswordField passwordInputed;

    @FXML
    private Button logRegButton;

    @FXML
    private Hyperlink registerCancelHLink;

    @FXML
    private Label consoleMsg;
    private UserService userService;
    private boolean onRegister;

    public void initialize() {
        userService = (UserService) ServiceRegistry.getInstance().getService(UserService.class.getSimpleName());
    }

    @FXML
    void onHLinkClicked(ActionEvent event) {

        if(onRegister) {
            loginMod();

        } else {
            registerMod();
        }
    }

    @FXML
    void onLogRegButtonPressed(ActionEvent event) {


        if(userName.getText().equals("") || passwordInputed.getText().equals("")) {
            consoleMsg.setText("Username or password missing");
            return;
        }

        if(onRegister && emailInputed.getText().equals("")) {
            consoleMsg.setText("Email missing");
            return;
        }

        if(!onRegister) {
            if(userService.authenticate(userName.getText(), Security.getHash(passwordInputed.getText()))) {
                userName.setText("");
                passwordInputed.setText("");
                consoleMsg.setText("Login sucessful");
                Navigation.getInstance().loadScreen("page1");

            } else {
                consoleMsg.setText("Username, password incorrect or you didnt register");
            }

        } else {

            if(userService.findByName(userName.getText()) == null) {

                if(validateEmail(emailInputed.getText())) {

                    User user = new User(userName.getText(), Security.getHash(passwordInputed.getText()), emailInputed.getText());
                    userService.addUser(user);
                    loginMod();
                    consoleMsg.setText("Registration sucessful");

                } else {
                    consoleMsg.setText("Invalid Email");
                }

            } else {
                consoleMsg.setText("That username is already taken, try another");
            }
        }
    }

    private void registerMod() {
        registerCancelHLink.setText("cancel");
        logRegButton.setText("Register");
        email.setVisible(true);
        emailInputed.setVisible(true);
        onRegister = true;
    }

    private void loginMod() {
        registerCancelHLink.setText("register");
        logRegButton.setText("Login");
        email.setVisible(false);
        emailInputed.setVisible(false);
        onRegister = false;
    }

    private boolean validateEmail(String email) {

        String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    @Override
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

