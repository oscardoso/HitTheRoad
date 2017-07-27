package org.academiadecodigo.bootcamp.persistence.hibernate;

import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.hibernate.Session;

/**
 * Created by codecadet on 24/07/2017.
 */
public class HibernateTransactionManager implements TransactionManager {


    @Override
    public void beginTransaction() {
        HibernateSessionManager.beginTransaction();
    }

    @Override
    public void commitTransaction() {
        HibernateSessionManager.commitTransaction();
    }

    @Override
    public void rollbackTransaction() {
        HibernateSessionManager.rollbackTransaction();
    }
}
