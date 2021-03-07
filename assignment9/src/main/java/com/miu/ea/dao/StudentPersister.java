/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.dao;

import com.miu.ea.business.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thai Nguyen
 */
@Repository
public class StudentPersister {
    public void insert(Student student, EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(student);
        tx.commit();
    }
}
