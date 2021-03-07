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

/**
 *
 * @author Thai Nguyen
 */
public class PersistenceService {

    private static EntityManager em = null;
    private StudentPersister studentPersister;

    public void setStudentPersister(StudentPersister studentPersister) {
        this.studentPersister = studentPersister;
    }

    public static synchronized void getEntityManager() {
        if (em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment9_1");
            em = emf.createEntityManager();
        }
    }

    public Student insertStudent(Student student) {
        PersistenceService.getEntityManager();
        studentPersister.insert(student, em);
        return student;
    }

}
