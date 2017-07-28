package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import org.academiadecodigo.bootcamp.model.TravelDistance;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.FileManager;
import org.academiadecodigo.bootcamp.persistence.SuppliesCalculator;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
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
    private UserService userService;

    public void initialize() {
        userService = (UserService) ServiceRegistry.getInstance().getService(UserService.class.getSimpleName());
        overallView();
    }

    @FXML
    void onClickSave(ActionEvent event) {

        System.out.println(userService.getCurrentUserName());

        FileManager.save(userService.getCurrentUserName() + TravelDistance.getOriginDestiny(), SuppliesCalculator.displayText());
        User user = userService.findByName(userService.getCurrentUserName());
        userService.addPreference(user, userService.getCurrentUserName() + TravelDistance.getOriginDestiny());
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



