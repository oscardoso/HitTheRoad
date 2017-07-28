package org.academiadecodigo.bootcamp.service.service.user;

import com.mysql.jdbc.Connection;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.jdbc.ConnectionManager;
import org.academiadecodigo.bootcamp.service.user.UserService;
import org.academiadecodigo.bootcamp.service.user.UserServiceJdbc;
import org.junit.Before;

/**
 * Created by codecadet on 28/07/2017.
 */
public class UserServiceJdbcTest {

    private static String username = "MockUser3";
    private static String email = "mockuser@email.com";
    private static String password = "mockpassword";

    public static void main(String[] args) {

        ConnectionManager connectionManager = new ConnectionManager();
        UserService userService = new UserServiceJdbc(connectionManager.getConnection());


        System.out.println("TESTING GET SERVICE NAME");
        System.out.println();
        System.out.println("Service name should be UserService ------> " + userService.getServiceName());
        System.out.println();


        System.out.println("TESTING AUTHENTICATE");
        System.out.println();

        System.out.println("TESTING ADD USER");
        System.out.println();

        //userService.addUser(new User(username, password, email));

        System.out.println("TESTING FIND BY NAME");
        System.out.println();
        System.out.println("Username should be MockUser -----> " + userService.findByName(username).getUsername());

        System.out.println();
        System.out.println("TESTING REMOVING USER");
        System.out.println();
        System.out.println("Number of users should be 4 ----> " + userService.count());
        userService.removeUser("MockUser3");
        userService.removeUser("MockUser2");
        userService.removeUser("MockUser7");
        System.out.println("Number of users should be 1 ----> " + userService.count());

    }
}
