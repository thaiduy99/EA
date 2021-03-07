/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea;

import com.miu.ea.model.Student;
import com.miu.ea.service.PersistenceService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Thai Nguyen
 */
public class StudentPersister {
//      1. By Type
//    @Autowired
//    private PersistenceService persistenceService;

//      2. By Constructor
//    private PersistenceService persistenceService;
//    @Autowired
//    public StudentPersister(PersistenceService persistenceService) {
//        this.persistenceService = persistenceService;
//    }    

//      3. By Name
    @Autowired
    private PersistenceService persistenceService;
    
    public Student insertStudent(Student student) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        PersistenceService service = context.getBean("persistenceService", PersistenceService.class);
        EntityManager em = service.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(student);

        tx.commit();
        return student;
    }

    public Student insertStudentByAuthowired(Student student) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
//        PersistenceService persistenceService = context.getBean("persistenceService", PersistenceService.class);
        EntityManager em = persistenceService.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(student);

        tx.commit();
        return student;
    }
}
