package org.academiadecodigo.bootcamp.controller;

import com.sun.org.apache.regexp.internal.RE;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.academiadecodigo.bootcamp.utils.Constants;

import static org.academiadecodigo.bootcamp.utils.Constants.LOGINVIEW;
import static org.academiadecodigo.bootcamp.utils.Constants.REGISTERVIEW;

/**
 * Created by codecadet on 27/07/2017.
 */
public class InitController implements Controller{


    @FXML
    private Button loginBtn1;

    @FXML
    private Button signUpBtn;

    @Override
    public void setUserService(UserService userService) {


    }

    public void onClickLogin(ActionEvent actionEvent) {
        Navigation.getInstance().loadScreen(LOGINVIEW);
    }

    public void onClickSignup(ActionEvent actionEvent) {
        Navigation.getInstance().loadScreen(REGISTERVIEW);
    }
}
