package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by codecadet on 21/07/2017.
 */
public class HibernateUserService implements UserService {


    @Override
    public String getServiceName() {
        return UserService.class.getSimpleName();
    }

    @Override
    public boolean authenticate(String userName, String pass) {

        System.out.println("username: " + userName + " pass: " + pass);

        // Get a specific user
        List list = HibernateSessionManager.beginTransaction().createCriteria(User.class)
                .add(Restrictions.eq("username", userName))
                .add(Restrictions.eq("password", pass))
                .list();
        User user = (User) list.get(0);

        HibernateSessionManager.commitTransaction();

        if(user != null){
            return true;
        }

        return false;
    }

    @Override
    public void addUser(User user) {

        try {

            Session session = HibernateSessionManager.beginTransaction();
            session.save(user);

            HibernateSessionManager.commitTransaction();

        } catch (HibernateException e) {
            HibernateSessionManager.rollbackTransaction();
        }

    }

    @Override
    public User findByName(String userName) {
        System.out.println("username: " + userName);

        // Get a specific user
        User user = (User) HibernateSessionManager.beginTransaction().createCriteria(User.class)
                .add(Restrictions.eq("username", userName)).uniqueResult();

        if(user != null) {

            return user;
        }
        return null;
    }

    @Override
    public int count() {
        Session session = HibernateSessionManager.beginTransaction();
        List list = session.createSQLQuery("SELECT * FROM user").list();

        return list.size();
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

}
