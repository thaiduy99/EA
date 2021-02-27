/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea;

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment5");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
//        initData(em);
//        updateData(em, 3L);
        removeData(em, 3L);
        
        
        tx.commit();
        em.close();
        emf.close();
    }
    
    public static void initData(EntityManager em){
        Student student1 = new Student();
        student1.setName("Thai Nguyen");
        student1.setGpa(3.68);
        
        Student student2 = new Student();
        student2.setName("Tien Pham");
        student2.setGpa(3.5);
        
        Student student3 = new Student();
        student3.setName("Nam Nguyen");
        student3.setGpa(4.0);
        
        Student student4 = new Student();
        student4.setName("Bao Nguyen");
        student4.setGpa(3.70);
        
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(student4);
    }
    
    public static void updateData(EntityManager em, Long id){
        Student st = em.find(Student.class, id);
        st.setName("Updated Name 11111");
    }
    
     public static void removeData(EntityManager em, Long id){
        Student st = em.find(Student.class, id);
        em.remove(st);
    }
    
}
