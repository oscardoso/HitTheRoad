package org.academiadecodigo.bootcamp;

import com.mysql.jdbc.Connection;
import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.Navigation;
import org.academiadecodigo.bootcamp.persistence.FileManager;
import org.academiadecodigo.bootcamp.persistence.SuppliesCalculator;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateTransactionManager;

import org.academiadecodigo.bootcamp.persistence.jdbc.ConnectionManager;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.academiadecodigo.bootcamp.service.user.UserServiceJdbc;

public class Main extends Application {

    private ConnectionManager connectionManager;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void init() {
        connectionManager = new ConnectionManager();
        UserService jservice = new UserServiceJdbc(connectionManager.getConnection());
        jservice.initializeDB();

        ServiceRegistry.getInstance().registerService(jservice);

    }

    @Override
    public void start(Stage primaryStage) {

        Navigation navigation = Navigation.getInstance();
        navigation.setStage(primaryStage);
        // load the first scene
        navigation.loadScreen("initView");

        FileManager.save("ruben", "poi");

    }

    public void close() {
        connectionManager.close();
    }

}
