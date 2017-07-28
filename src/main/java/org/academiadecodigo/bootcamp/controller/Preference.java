package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.academiadecodigo.bootcamp.persistence.FileManager;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;

import static org.academiadecodigo.bootcamp.utils.Constants.LETSGOVIEW;
import static org.academiadecodigo.bootcamp.utils.Constants.OVERALLVIEW;

public class Preference {

    @FXML
    private Label prefLabel;

    @FXML
    private TextField loadtext;

    @FXML
    private Button backButton;

    @FXML
    private Button loadButton;
    private UserService userService;
    String[] prefs;


    @FXML
    void onClickBack(ActionEvent event) {

        Navigation.getInstance().loadScreen(LETSGOVIEW);
    }

    @FXML
    void onClickLoad(ActionEvent event) {

        if(loadtext.getText() != null) {
            for(int i = 0; i < prefs.length; i++) {
                if(loadtext.getText().equals(prefs[i])) {
                    SuppliesDisplay.fileToLoad = FileManager.load(loadtext.getText());
                    System.out.println(SuppliesDisplay.fileToLoad);
                    prefLabel.setText(SuppliesDisplay.fileToLoad);
                    return;
                }
            }
        }

    }

    public void initialize() {
        userService = (UserService) ServiceRegistry.getInstance().getService(UserService.class.getSimpleName());

        prefs = userService.findPreferences(userService.getCurrentUserName());
        String displayPref = "";

        for(int i = 0; i < prefs.length; i++) {
            if(prefs[i] == null) {
                break;
            }

            displayPref += prefs[i] + "\n";
        }

        prefLabel.setText(displayPref);

    }
}

