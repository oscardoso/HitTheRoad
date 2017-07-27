package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.model.User;

import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateTransactionManager;
import org.academiadecodigo.bootcamp.service.user.UserServiceImpl;
import org.academiadecodigo.bootcamp.utils.Security;

/**
 * Created by codecadet on 24/07/2017.
 */
public class testDao {

    public static void main(String[] args) {

        UserServiceImpl service = new UserServiceImpl();
       // service.setUserDao(new HibernateUserDao());
        service.setTransactionManager(new HibernateTransactionManager());

        service.addUser(new User("ruben", "ruben", "ruben@poi.poi"));
        service.authenticate("ruben", Security.getHash("ruben"));

    }
}
