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

        String origem = "";
        String destino = "";

        if(originField.getText().split(" ").length > 1) {
            origem += originField.getText().replace(" ", "");
        } else {
            origem = originField.getText();
        }
        if(destinyField.getText().split(" ").length > 1) {
            destino += destinyField.getText().replace(" ", "");
        } else {
            destino = destinyField.getText();
        }

        origem = origem.toLowerCase();
        destino = destino.toLowerCase();

        TravelDistance.distance(origem, destino);

        if(TravelDistance.getOrigemFinal() == null || TravelDistance.getDestinoFinal() == null) {
            routeNotFoundWarning.setVisible(true);
            return;
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
        routeNotFoundWarning.setVisible(false);
    }
}
