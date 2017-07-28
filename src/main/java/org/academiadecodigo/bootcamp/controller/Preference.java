package org.academiadecodigo.bootcamp.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.academiadecodigo.bootcamp.service.user.UserServiceJdbc;

public class Preference {

    @FXML
    private Label preferencesDisplay;

    @FXML
    private TextField preferenceSelector;
    private UserService userService;

    public void initialize() {
        userService = (UserService) ServiceRegistry.getInstance().getService(UserService.class.getSimpleName());

        String[] prefs = userService.findPreferences(UserServiceJdbc.getCurrentUserName());
    }

}

