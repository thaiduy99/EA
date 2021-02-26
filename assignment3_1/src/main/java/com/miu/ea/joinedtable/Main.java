/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.joinedtable;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Thai Nguyen
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment3_1");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
//        Student student = new Student();        

        OnCampusStudent onCampusStudent = new OnCampusStudent();
        onCampusStudent.setName("Thai Nguyen");
        onCampusStudent.setGpa(3.6);
        onCampusStudent.setBuilding("142");
        onCampusStudent.setRoom(213);
        em.persist(onCampusStudent);

        JobSearchStudent jobSearchStudent = new JobSearchStudent();
        jobSearchStudent.setName("Genzo");
        jobSearchStudent.setGpa(4.0);
        jobSearchStudent.setResume("Ansi C and Embedded System");
        jobSearchStudent.setStartJobSearchDate(LocalDate.now());
        em.persist(jobSearchStudent);

        CPTStudent cptStudent1 = new CPTStudent();
        cptStudent1.setName("Tien Pham");
        cptStudent1.setGpa(3.0);
        cptStudent1.setJob("Java BackEnd");
        cptStudent1.setSalary(200000);
        Laptop laptop = new Laptop();
        laptop.setHdsize("200TB");
        laptop.setPrice(1200);
        laptop.setRam("32GB");
        cptStudent1.setLaptop(laptop);
        em.persist(cptStudent1);

        CPTStudent cptStudent2 = new CPTStudent();
        cptStudent2.setName("Tam Ho");
        cptStudent2.setGpa(3.8);
        cptStudent2.setJob("Senior FullStack Developer");
        cptStudent2.setSalary(210000);
        Laptop laptop2 = new Laptop();
        laptop2.setHdsize("500TB");
        laptop2.setPrice(3000);
        laptop2.setRam("32GB");
        cptStudent2.setLaptop(laptop2);
        em.persist(cptStudent2);

        getAllCPTStudent(em);
        getLaptopOfCPTStudent(em, 3.0);
        getAllStudentsHavingLaptop(em, "32GB");

        tx.commit();
        em.close();
        emf.close();
    }

    public static void getAllCPTStudent(EntityManager em) {
        String queryStr = "SELECT cpt FROM CPTStudent cpt";
        Query query = em.createQuery(queryStr);
        List<CPTStudent> list = query.getResultList();

        System.out.println("***************** List CPT Student ***********************");
        for (CPTStudent cpt : list) {
            Long id = cpt.getId();
            Student st = em.find(Student.class, id);
            cpt.setName(st.getName());
            cpt.setGpa(st.getGpa());
            System.out.println("[" + cpt.getName() + " " + cpt.getGpa() + " " + cpt.getJob() + " " + cpt.getSalary() + "]");
        }
        System.out.println("**********************************************************");
    }

    public static void getLaptopOfCPTStudent(EntityManager em, Double gpa) {
        System.out.println("***************** Laptop of Student with GPA ***********************");
        String queryStr = "SELECT s.laptop FROM Student s where s.gpa = :gpa";
        TypedQuery<Laptop> query = em.createQuery(queryStr, Laptop.class);
        query.setParameter("gpa", gpa);
        Laptop laptop = query.getSingleResult();
        System.out.println(laptop);
        System.out.println("********************************************************************");
    }

    public static void getAllStudentsHavingLaptop(EntityManager em, String ram) {
        System.out.println("***************** All Student have laptop with 32GB ***********************");
        String queryStr = "SELECT s FROM Student s where s.laptop.ram = :ram";
        TypedQuery<Student> query = em.createQuery(queryStr, Student.class);
        query.setParameter("ram", ram);
        List<Student> students = query.getResultList();
        for(Student student : students){
            CPTStudent cpt = em.find(CPTStudent.class, student.getId());
            System.out.println("CPTStudent{" + "name= "+ student.getName() + ", gpa= " + student.getGpa() + ", job= " + cpt.getJob() + ", salary= " + cpt.getSalary() + '}');
        }
        System.out.println("****************************************************************************");
    }
}
