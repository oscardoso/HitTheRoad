package org.academiadecodigo.bootcamp.service.jdbc;

import org.academiadecodigo.bootcamp.model.Supplies;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.jdbc.ConnectionManager;
import org.academiadecodigo.bootcamp.service.user.UserService;

import java.sql.*;

/**
 * Created by codecadet on 14/07/2017.
 */
public class JdbcUserService implements UserService {

    private Connection connection;

    public JdbcUserService(ConnectionManager connectionManager) {
        this.connection = connectionManager.getConnection();
    }


    @Override
    public boolean authenticate(String userName, String pass) {
        try {

            // create a query
            String query = "SELECT username, password FROM user WHERE user.username = ? AND user.password = ?";
            //System.out.println(query);

            PreparedStatement statement = connection.prepareStatement(query);

            // set values for the placeholders
            statement.setString(1, userName);
            statement.setString(2, pass);

            System.out.println(userName + " and " + pass);

            // execute the query
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

        try {

            //Statement statement = connectionManager.createStatement();

            // create a query
            String query = "INSERT INTO user(username, password, email) " +
                    "VALUES (? , ? , ?)";

            PreparedStatement statement = connection.prepareStatement(query);

            // set values for the placeholders
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());

            // execute the query
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failure to connect to database : " + e.getMessage());
        }

    }

    @Override
    public User findByName(String userName) {

        try {
            // ... connection and statements....
            User user = null;

            // create a query
            String query = "SELECT username FROM user WHERE username = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            // set values for the placeholders
            statement.setString(1, userName);

            // execute the query
            ResultSet resultSet = statement.executeQuery();

            // user exists
            if (resultSet.next()) {

                String usernameValue = resultSet.getString("username");
                String passwordValue = resultSet.getString("password");
                String emailValue = resultSet.getString("email");

                user = new User(usernameValue, passwordValue, emailValue);
                return user;
            }

            if(statement != null) {
                statement.close();
            }
            // ....
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
            Statement statement = connection.createStatement();

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

    @Override
    public void initializeDB() {

        try {

            for (int i = 0; i < SuppliesType.values().length; i++) {

                // create a query
                String query = "INSERT INTO supplies(name) " +
                        "VALUES (?)";

                PreparedStatement statement = connection.prepareStatement(query);

                // set values for the placeholders
                statement.setString(1, SuppliesType.values()[i].getDescription());

                // execute the query
                statement.executeUpdate();

            }
        } catch (SQLException e) {
            System.out.println("Failure to connect to database : " + e.getMessage());
        }
    }


    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failure to close database connections: " + e.getMessage());
        }
    }

    @Override
    public String getServiceName() {
        return UserService.class.getSimpleName();
    }
}
