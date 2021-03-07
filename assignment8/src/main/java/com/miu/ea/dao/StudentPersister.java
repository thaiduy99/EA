/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.dao;

import com.miu.ea.model.Student;
import javax.persistence.EntityManager;

/**
 *
 * @author Thai Nguyen
 */
public class StudentPersister {

    public StudentPersister() {
    }

    public Student insert(EntityManager em, Student student) {
        em.persist(student);
        return student;
    }
}
