package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;

import org.academiadecodigo.bootcamp.persistence.TransactionManager;


/**
 * Created by codecadet on 24/07/2017.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private TransactionManager transactionManager;
    private RoleDao roleDao;


    @Override
    public String getServiceName() {
        return UserService.class.getSimpleName();
    }

    @Override
    public boolean authenticate(String userName, String pass) {

        transactionManager.beginTransaction();

        User user = userDao.findByName(userName);

        Boolean isAuthenticated = false;

        if(user != null) {

            isAuthenticated = (user.getPassword().equals(pass));

        }

        transactionManager.commitTransaction();

        return isAuthenticated;
    }

    @Override
    public void addUser(User user) {

        transactionManager.beginTransaction();

        userDao.addUser(user);

        transactionManager.commitTransaction();
    }

    @Override
    public void removeUser(String username) {

    }

    @Override
    public User findByName(String userName) {

        transactionManager.beginTransaction();

        User user = userDao.findByName(userName);

        transactionManager.commitTransaction();

        return user;
    }

    @Override
    public int count() {

        transactionManager.beginTransaction();

        int count = userDao.count();

        transactionManager.commitTransaction();

        return count;
    }

    @Override
    public void initializeDB() {

    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
