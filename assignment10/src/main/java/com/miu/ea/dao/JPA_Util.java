/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thai Nguyen
 */
public final class JPA_Util {

    //Create EntityManager as Singleton pattern
    private final static EntityManager entityManager;
    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment10");
        entityManager = emf.createEntityManager();
    }  

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
