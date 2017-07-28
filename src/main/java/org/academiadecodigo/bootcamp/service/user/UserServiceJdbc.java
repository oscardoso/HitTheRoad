package org.academiadecodigo.bootcamp.service.user;


import com.mysql.jdbc.Statement;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.jdbc.SuppliesType;
import org.academiadecodigo.bootcamp.utils.Security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by codecadet on 27/07/2017.
 */
public class UserServiceJdbc implements UserService {

    private Connection connection;


    public UserServiceJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String getServiceName() {
        return UserService.class.getSimpleName();
    }

    @Override
    public boolean authenticate(String userName, String pass) {

        if (findByName(userName) == null ||
                Security.getHash(findByName(userName).getPassword()) != Security.getHash(pass)){
            return false;
        }
        return true;
    }

    @Override
    public void addUser(User user) {
        Statement statement = null;

        try {

            statement = (Statement) connection.createStatement();
            String update = "INSERT INTO user (username, password, email) " +
                    "VALUES('" + user.getUsername() + "','" + Security.getHash(user.getPassword()) + "','" + user.getEmail() + "');";
            statement.executeUpdate(update);

        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }


    }

    @Override
    public User findByName(String userName) {

        try {

            String query = "SELECT * FROM user WHERE username=?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, userName);
            System.out.println(query);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String usernameValue = resultSet.getString("username");
                String passwordValue = resultSet.getString("password");
                String emailValue = resultSet.getString("email");


                statement.close();

                return new User(usernameValue, emailValue, passwordValue);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


        return null;
    }

    @Override
    public int count() {

        try {

            int result = 0;

            // create a new statement
            java.sql.Statement statement = connection.createStatement();

            // create a query
            String query = "SELECT COUNT(*) FROM user;";

            // execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // get the results
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

            return result;

        } catch (SQLException e) {
            System.out.println("Failure to close database connections: " + e.getMessage());
        }

        return 0;
    }

    public void removeUser(String username){
        Statement statement = null;

        try {
            statement = (Statement) connection.createStatement();
            String update = "DELETE FROM user where username = '"+ username + "';";
            System.out.println(update);
            statement.executeUpdate(update);

        } catch (SQLException e) {
            System.err.println("ERROR: "+e.getMessage());
            e.printStackTrace();
        }

    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failure to close database connections: " + e.getMessage());
        }
    }

    @Override
    public void initializeDB() {
        try {

            int result = 0;
            java.sql.Statement statement1 = connection.createStatement();
            String query1 = "SELECT COUNT(*) FROM supplies;";
            ResultSet resultSet = statement1.executeQuery(query1);

            // get the results
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }

            if (result == 0) {

                for (int i = 0; i < SuppliesType.values().length; i++) {

                    String query = "INSERT INTO supplies(name) " +
                            "VALUES (?)";

                    java.sql.PreparedStatement statement = connection.prepareStatement(query);

                    statement.setString(1, SuppliesType.values()[i].getDescription());

                    statement.executeUpdate();
                }

            }
        } catch (SQLException e) {
            System.out.println("Failure to connect to database : " + e.getMessage());
        }

    }
}
