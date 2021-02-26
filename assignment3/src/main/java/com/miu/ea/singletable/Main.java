/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.singletable;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Thai Nguyen
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment3");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        OnCampusStudent onCampusStudent = new OnCampusStudent();       
        onCampusStudent.setName("Thai Nguyen");
        onCampusStudent.setGpa(3.6);
        onCampusStudent.setBuilding(142);
        onCampusStudent.setRoom(213);
        em.persist(onCampusStudent);
        
        JobSearchStudent jobSearchStudent = new JobSearchStudent();
        jobSearchStudent.setName("Genzo");
        jobSearchStudent.setGpa(4);
        jobSearchStudent.setResume("Ansi C and Embedded System");
        jobSearchStudent.setStartJobSearchDate(LocalDate.now());
        em.persist(jobSearchStudent);
        
        CPTStudent cptStudent = new CPTStudent();
        cptStudent.setName("Tien Pham");
        cptStudent.setGpa(3.6);
        cptStudent.setJob("Java BackEnd");
        cptStudent.setSalary(200000);
        em.persist(cptStudent);
        
        tx.commit();
        em.close();
        emf.close();
    }    
}
