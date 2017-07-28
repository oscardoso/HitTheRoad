package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import org.academiadecodigo.bootcamp.model.TravelDistance;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.academiadecodigo.bootcamp.persistence.FileManager;
import org.academiadecodigo.bootcamp.persistence.SuppliesCalculator;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.academiadecodigo.bootcamp.service.user.UserServiceJdbc;

public class OverallController implements Controller {

    @FXML
    private Label overall;

    @FXML
    private Button saveButton;

    @FXML
    private Label suppliesField1;

    @FXML
    private Label suppliesField2;

    @FXML
    void onClickSave(ActionEvent event) {


    }

    public void initialize() {
        overallView();
    }

    public void overallView() {

        overall.setText("");
        overall.setText("Origin: " + TravelDistance.getOrigemFinal() +
                " | Destination: " + TravelDistance.getDestinoFinal() +
                " | Distance: " + TravelDistance.getKilometres() + " km" +
                " | Days Walking: " + TravelDistance.getNumberOfDays() + "      (30km/day avg)");

        String left = "";
        String right = "";
        String[] supplies = SuppliesCalculator.displayText().split("\n");

        for(int i = 0; i < supplies.length; i++) {
            if(i < 8) {
                left += supplies[i] + "\n";
            }
            if(i == 8) {
                left += supplies[i];
            }
            if (i > 8) {
                right += supplies[i] + "\n";
            }
        }

        suppliesField1.setText(left);
        suppliesField2.setText(right);

    }

    @Override
    public void setUserService(UserService userService) {

    }
}



