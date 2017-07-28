package org.academiadecodigo.bootcamp.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import org.academiadecodigo.bootcamp.persistence.FileManager;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.academiadecodigo.bootcamp.service.user.UserServiceJdbc;

public class Preference {

    @FXML
    private Button buttonExit;

    @FXML
    private Label preferencesDisplay;

    @FXML
    private TextField preferenceSelector;
    private UserService userService;

    public void initialize() {
        userService = (UserService) ServiceRegistry.getInstance().getService(UserService.class.getSimpleName());

        String[] prefs = userService.findPreferences(UserServiceJdbc.getCurrentUserName());
        String displayPref = "";

        for(int i = 0; i < prefs.length; i++) {
            displayPref += prefs[i] + "\n";
        }

        preferencesDisplay.setText(displayPref);

    }

    @FXML
    void exit(ActionEvent event) {


    }

    @FXML
    void loadFile(ActionEvent event) {
        preferencesDisplay.setText(FileManager.load(preferenceSelector.getText()));
    }

}

