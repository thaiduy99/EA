/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.service;

import com.miu.ea.dao.StudentPersister;
import com.miu.ea.model.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.stereotype.Component;

/**
 *
 * @author Thai Nguyen
 */
public class PersistenceService {

    private EntityManager em = null;

    public PersistenceService() {
    }

    public EntityManager getEntityManager() {
        if (em != null) {
            return em;
        } else {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment8");
            em = emf.createEntityManager();
            return em;
        }
    }

    public Student saveStudent(Student student) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        StudentPersister sp = new StudentPersister();
        sp.insert(entityManager, student);
        tx.commit();
        return student;
    }
}
