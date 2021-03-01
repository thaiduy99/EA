/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea;

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment3_2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        initData(em);
                
        tx.commit();
        em.close();
        emf.close();        
    }    
    public static void initData(EntityManager em){
        CPTStudent cpt = new CPTStudent();
        cpt.setName("Tien Pham");
        cpt.setGpa(3.6D);
        cpt.setJob("Backend Developer");
        cpt.setSalary(150000);
        CPTStudent cpt1 = new CPTStudent();
        cpt1.setName("Tam Ho");
        cpt1.setGpa(3.6D);
        cpt1.setJob("Fullstack Developer");
        cpt1.setSalary(200000);
        em.persist(cpt);
        em.persist(cpt1);
        
        OnCampusStudent onStudent = new OnCampusStudent();
        onStudent.setName("Thai Nguyen");
        onStudent.setGpa(3.6D);
        onStudent.setBuilding(142);
        onStudent.setRoom(213);
        
        OnCampusStudent onStudent1 = new OnCampusStudent();
        onStudent1.setName("Phuoc Doan");
        onStudent1.setGpa(3.6D);
        onStudent1.setBuilding(142);
        onStudent1.setRoom(211);        
        em.persist(onStudent);
        em.persist(onStudent1);
        
        JobSearchStudent jsStudent = new JobSearchStudent();
        jsStudent.setGpa(3.9);
        jsStudent.setName("Genzo");
        jsStudent.setResume("Java Skills");
        jsStudent.setStartJobSearchDate(LocalDate.now());
        
        JobSearchStudent jsStudent1 = new JobSearchStudent();
        jsStudent1.setGpa(3.9);
        jsStudent1.setName("Mohan");
        jsStudent1.setResume("PHP Skills");
        jsStudent1.setStartJobSearchDate(LocalDate.now());
        em.persist(jsStudent);
        em.persist(jsStudent1);
    }
}
