package org.academiadecodigo.bootcamp.persistence;

import org.hibernate.Session;

/**
 * Created by codecadet on 24/07/2017.
 */
public interface TransactionManager {

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();
}
