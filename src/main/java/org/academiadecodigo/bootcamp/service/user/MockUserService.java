package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codecadet on 08/07/2017.
 */
public class MockUserService implements UserService {

    private List<User> userDataBase = new ArrayList<User>();
    private boolean userOnDataBase;


    @Override
    public boolean authenticate(String userName, String pass) {

        for (User user : userDataBase) {
            if(user.getUsername().equals(userName) && user.getPassword().equals(pass)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void addUser(User user) {

        userOnDataBase = false;

        for (User user1 : userDataBase) {
            if(user1.getUsername().equals(user.getUsername())) {
                userOnDataBase = true;
                return;
            }
        }

        userDataBase.add(user);
    }

    @Override
    public void removeUser(String username) {

    }

    @Override
    public User findByName(String userName) {

        for (User user : userDataBase) {
            if(user.getUsername().equals(userName)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public int count() {
        return userDataBase.size();
    }

    @Override
    public void initializeDB() {

    }

    @Override
    public String[] findPreferences(String name) {
        return new String[0];
    }

    @Override
    public void addPreference(User user, String pref) {

    }

    @Override
    public String getCurrentUserName() {
        return null;
    }

    @Override
    public String getServiceName() {
        return UserService.class.getSimpleName();
    }
}
