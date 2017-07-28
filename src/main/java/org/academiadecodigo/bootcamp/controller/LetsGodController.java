package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.academiadecodigo.bootcamp.model.TravelDistance;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;

import static org.academiadecodigo.bootcamp.utils.Constants.LETSGOVIEW;
import static org.academiadecodigo.bootcamp.utils.Constants.OVERALLVIEW;

/**
 * Created by codecadet on 28/07/2017.
 */
public class LetsGodController implements Controller{

    private UserService userService;

    @FXML
    private Label routeNotFoundWarning;

    @FXML
    private TextField originField;

    @FXML
    private TextField destinyField;

    @FXML
    private Button signupButton;

    @FXML
    private Button letsGoBtn;

    @FXML
    void lestGoClick(ActionEvent event) {

        TravelDistance.distance(originField.getText(), destinyField.getText());

        if(TravelDistance.getOrigemFinal() == null) {
            routeNotFoundWarning.setVisible(true);
        }

        Navigation.getInstance().loadScreen(OVERALLVIEW);
    }

    @FXML
    void onClickSignup(ActionEvent event) {

    }

    @FXML
    void onKeyPressed(ActionEvent event) {

    }

    @Override
    public void setUserService(UserService userService) {

    }

    public void initialize() {
        userService = (UserService) ServiceRegistry.getInstance().getService(UserService.class.getSimpleName());
    }
}
