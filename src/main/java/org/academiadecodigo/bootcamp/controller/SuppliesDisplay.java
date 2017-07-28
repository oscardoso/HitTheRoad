package org.academiadecodigo.bootcamp.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;

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

    public static String fileToLoad;

    public void initialize() {
        userService = (UserService) ServiceRegistry.getInstance().getService(UserService.class.getSimpleName());
    }

    @FXML
    void SuppliesNextButtonPressed(ActionEvent event) {

    }


    //cuidado falta o user!!!!!
    @FXML
    void buttonSaveSuppliesPressed(ActionEvent event) {

        //FileManager.save(, SuppliesDisplayText.getText());
    }

    @Override
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

