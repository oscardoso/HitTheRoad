package org.academiadecodigo.bootcamp.controller;

import com.sun.org.apache.regexp.internal.RE;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.academiadecodigo.bootcamp.service.user.UserService;

/**
 * Created by codecadet on 27/07/2017.
 */
public class InitController implements Controller{

    private final String LOGIN_VIEW = "login";
    private final String REGISTER_VIEW = "register";

    @FXML
    private Button loginBtn1;

    @FXML
    private Button signUpBtn;

    @FXML
    void onLoginClick(ActionEvent event) {
        Navigation.getInstance().loadScreen(LOGIN_VIEW);
    }

    @FXML
    void onSignUpClick(ActionEvent event) {
        Navigation.getInstance().loadScreen(REGISTER_VIEW);
    }


    @Override
    public void setUserService(UserService userService) {


    }
}
