package org.academiadecodigo.bootcamp.service.controller;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.Navigation;

/**
 * Created by codecadet on 27/07/2017.
 */
public class InitControllerTest extends Application{

    public static void main(String[] args) {
        launch(args);
    }




    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("initView");


    }
}
