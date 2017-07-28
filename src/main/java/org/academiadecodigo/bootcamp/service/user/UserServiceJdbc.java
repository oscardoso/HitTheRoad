package org.academiadecodigo.bootcamp.service.user;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.jdbc.SuppliesType;
import org.academiadecodigo.bootcamp.utils.Security;

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
        try {

            String query = "SELECT username, password FROM user WHERE user.username = ? AND user.password = ?";

            java.sql.PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, userName);
            statement.setString(2, pass);

            System.out.println(userName + " and " + pass);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                return true;
            }

        } catch (SQLException e) {
            System.out.println("Failure to connect to database : " + e.getMessage());
        }

        return false;

    }

    @Override
    public void addUser(User user) {
        Statement statement = null;

        try {
            statement = (Statement) connection.createStatement();
            String update = "INSERT INTO user (username, password, email) " +
                    "VALUES('" + user.getUsername() + "','" + user.getPassword() + "','" + user.getEmail() + "');";
            statement.executeUpdate(update);

        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }


    }

    @Override
    public User findByName(String userName) {

        try {
            User user = null;

            String query = "SELECT username FROM user WHERE username = ?";

            java.sql.PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, userName);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                String usernameValue = resultSet.getString("username");
                String passwordValue = resultSet.getString("password");
                String emailValue = resultSet.getString("email");

                user = new User(usernameValue, passwordValue, emailValue);
                return user;
            }

            if (statement != null) {
                statement.close();
            }

        } catch (SQLException e) {
            System.out.println("Failure to connect to database : " + e.getMessage());
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
