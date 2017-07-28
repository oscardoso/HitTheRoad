package org.academiadecodigo.bootcamp.service.user;

import java.sql.Array;
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

    private static String currentUserName;


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

            currentUserName = userName;

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
                int id = resultSet.getInt("id");

                user = new User(id, usernameValue, passwordValue, emailValue);
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

    @Override
    public String[] findPreferences(String name) {

        try {

            int id = findByName(name).getId();

            String query = "SELECT name FROM preferences WHERE userID = ?";

            java.sql.PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            Object[] type;
            Array prefs = resultSet.getArray("name");
            type = (Object [])prefs.getArray();

            String[] preferences = new String[type.length];

            for(int i = 0; i < preferences.length; i++) {
                preferences[i] = type[i].toString();
            }

            return preferences;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void addPreference(User user, String pref) {

        try {

            String query = "INSERT INTO preferences(userID, name) " +
                    "VALUES (?, ?)";

            java.sql.PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, user.getId());
            statement.setString(2, pref);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static String getCurrentUserName() {
        return currentUserName;
    }

}
