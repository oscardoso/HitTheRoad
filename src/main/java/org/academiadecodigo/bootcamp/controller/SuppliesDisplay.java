package org.academiadecodigo.bootcamp.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.academiadecodigo.bootcamp.model.TravelDistance;
import org.academiadecodigo.bootcamp.persistence.FileManager;
import org.academiadecodigo.bootcamp.persistence.SuppliesCalculator;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.academiadecodigo.bootcamp.service.user.UserServiceJdbc;

public class SuppliesDisplay implements Controller{

    @FXML
    private Button saveSupplies;

    @FXML
    private Button SuppliesNext;

    @FXML
    private Label suppliesLeftLabel;

    @FXML
    private Label suppliesRightLabel;
    private UserService userService;

    public void initialize() {
        userService = (UserService) ServiceRegistry.getInstance().getService(UserService.class.getSimpleName());

        String[] supplies = new String[15];
        supplies = SuppliesCalculator.displayText().split("\n");

        String left = "";
        String right = "";

        for(int i = 0; i < supplies.length; i++) {
            if(i < 8) {
                left += supplies[i] + "\n";
            }
            if(i == 8) {
                left += supplies[i];
            }
            else {
                right += supplies[i] + "\n";
            }
        }

        suppliesLeftLabel.setText(left);
        suppliesRightLabel.setText(right);
    }

    @FXML
    void SuppliesNextButtonPressed(ActionEvent event) {

    }

    @FXML
    void buttonSaveSuppliesPressed(ActionEvent event) {

        FileManager.save(UserServiceJdbc.getCurrentUserName() + TravelDistance.getOriginDestiny(), SuppliesCalculator.displayText());
    }

    @Override
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

