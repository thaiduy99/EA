/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thai Nguyen
 */
public class PersistenceService {

    private static EntityManager em = null;

    public PersistenceService() {
    }

    public static synchronized EntityManager getEntityManager() {
//        if (uniqueInstance == null) {
//            synchronized (Singleton.class) {
//                if (uniqueInstance == null) {
//                    uniqueInstance = new Singleton();
//                }
//            }
//        }

        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment8_1");
            em = emf.createEntityManager();
        }
        return em;
    }
}
