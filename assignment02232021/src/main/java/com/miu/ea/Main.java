/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Thai Nguyen
 */
public class Main {

    public void insert() {
        String name = "Thai Nguyen";
        String studenID = "611524";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment02232021");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        for (int i = 1; i <= 10; i++) {
            Student student = new Student();
            student.setName(name + " " + i);
            student.setStudentID(studenID + "_" + i);
            student.setGrade(2.5);
//            student.setBook(null);
            em.persist(student);
        }
        tx.commit();
        em.close();
        emf.close();
    }

    public void delete() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment02232021");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        for (int i = 58; i <= 60; i++) {
            Student student = em.find(Student.class, new Long(i));
            if (student != null) {
                em.remove(student);
            }
        }
        tx.commit();
        em.close();
        emf.close();
    }

    public void update() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment02232021");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student student = em.find(Student.class, new Long(55));
        student.setName("Updated your name");
        em.persist(student);
        tx.commit();
        em.close();
        emf.close();
    }

    public void query() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment02232021");
        EntityManager em = emf.createEntityManager();
        String queryStr = "SELECT s FROM Student s";
        Query query = em.createQuery(queryStr);
        List<Student> result = query.getResultList();
        result.forEach(e -> System.out.println(e));
        em.close();
        emf.close();
    }

    public void insertWithBook() {
        String name = "Thai Nguyen";
        String studenID = "611524";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment02232021");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        for (int i = 1; i <= 5; i++) {
            Student student = new Student();
            student.setName(name + " " + i);
            student.setStudentID(studenID + "_" + i);
            student.setGrade(2.5);
            Book book1 = new Book();
            book1.setTitle("The history of time " + i);
            book1.setNumPage(345);
            student.setBook(book1);

            Book book2 = new Book();
            book2.setTitle("Chicken Soup for the Soul " + i);
            book2.setNumPage(345);
            student.setBook(book2);
//            CascadeType.PERSIST
//            em.persist(book1);
//            em.persist(book2);
            em.persist(student);
        }
//        String queryStr = "SELECT s.book FROM Student s where s.id = 5";
//        Query query = em.createQuery(queryStr);
//        List<Book> result = query.getResultList();
//        result.forEach(e -> System.out.println(e));
        tx.commit();
        em.close();
        emf.close();
    }
    
    public void insertStudentWithCourse() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment02232021");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student student1 = new Student();
        student1.setStudentID("611524");
        student1.setName("Thai Nguyen");
        student1.setGrade(3.6);
        List<Student> l = new ArrayList<>();
        l.add(student1);
        
        List<Course> list = new ArrayList<>();
        Course course1 = new Course();
        course1.setName("Enterprise Architecture");
        course1.setShortName("EA");
        course1.setRegister(l);
        list.add(course1);
        
        Course course2 = new Course();
        course2.setName("Web Application Programming");
        course2.setShortName("WAP");       
        course2.setRegister(l);
        list.add(course2);
        
        Course course3 = new Course();
        course3.setName("Advance Software Design");
        course3.setShortName("ASD");
        course3.setRegister(l);
        list.add(course3);
        
        student1.setCourses(list);   
        em.persist(student1);
        tx.commit();
        em.close();
        emf.close();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.insertStudentWithCourse();
//        main.insertWithBook();
//        main.query();
//        main.delete();
//        main.update();
    }
}
