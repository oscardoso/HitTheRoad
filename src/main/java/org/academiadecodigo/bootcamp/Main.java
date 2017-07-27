package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.Navigation;
<<<<<<< HEAD
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateTransactionManager;
=======
>>>>>>> 91e9b4d3229b4a1f90d441fe2cf8528e55585aa2
import org.academiadecodigo.bootcamp.persistence.jdbc.ConnectionManager;
import org.academiadecodigo.bootcamp.service.jdbc.JdbcUserService;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.user.UserService;

public class Main extends Application {

    private ConnectionManager connectionManager;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void init() {
        connectionManager = new ConnectionManager();
        UserService jservice = new JdbcUserService(connectionManager);
        jservice.initializeDB();
        //UserService hservice = new HibernateUserService();
        /*UserServiceImpl service = new UserServiceImpl();
        service.setTransactionManager(new HibernateTransactionManager());
<<<<<<< HEAD
      //  service.setUserDao(new HibernateUserDao());
       // service.setRoleDao(new HibernateRoleDao());
        ServiceRegistry.getInstance().registerService(service);
=======
        service.setUserDao(new HibernateUserDao());
        service.setRoleDao(new JdbcUserService());*/
        ServiceRegistry.getInstance().registerService(jservice);
>>>>>>> 91e9b4d3229b4a1f90d441fe2cf8528e55585aa2

    }

    @Override
    public void start(Stage primaryStage) {

        Navigation navigation = Navigation.getInstance();
        navigation.setStage(primaryStage);
        // load the first scene
        navigation.loadScreen("login");

    }

    public void close() {
        connectionManager.close();
    }

}
