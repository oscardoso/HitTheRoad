package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.Service;

/**
 * Created by codecadet on 08/07/2017.
 */
public interface UserService extends Service {

    boolean authenticate(String userName, String pass);

    void addUser(User user);

    User findByName(String userName);

    int count();

    void initializeDB();
}
