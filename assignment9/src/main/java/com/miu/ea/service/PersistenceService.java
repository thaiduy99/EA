/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.service;

import com.miu.ea.business.Student;
import com.miu.ea.dao.StudentPersister;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thai Nguyen
 */
@Service
public class PersistenceService {

    private static EntityManager em = null;
    @Autowired
    private StudentPersister studentPersister;

    public static synchronized void getEntityManager() {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment9");
            em = emf.createEntityManager();
        }
    }

    public Student insertStudent(Student student) {
        PersistenceService.getEntityManager();
        studentPersister.insert(student, em);
        return student;
    }

}
