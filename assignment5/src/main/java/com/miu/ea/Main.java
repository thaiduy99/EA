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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

        initData(em);
//        getStudentHaveLaptopWithHarddisk(em);
        getAllLaptopOfStudent(em);
//        updateData(em, 3L);
//        removeData(em, 3L);
//        testing(em, 20L);

        tx.commit();
        em.close();
        emf.close();
    }

    public static void initData(EntityManager em) {
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

        Laptop laptop1 = new Laptop();
        laptop1.setRam(8);
        laptop1.setHarddisk("501TB");
        laptop1.setPrice(750);

        Laptop laptop2 = new Laptop();
        laptop2.setRam(8);
        laptop2.setHarddisk("502TB");
        laptop2.setPrice(750);

        Laptop laptop3 = new Laptop();
        laptop3.setRam(8);
        laptop3.setHarddisk("503TB");
        laptop3.setPrice(750);

        Laptop laptop4 = new Laptop();
        laptop4.setRam(8);
        laptop4.setHarddisk("504TB");
        laptop4.setPrice(750);

        List<Laptop> l1 = new ArrayList<>();
        l1.add(laptop1);
        l1.add(laptop2);
        student1.setLaptops(l1);

        List<Laptop> l2 = new ArrayList<>();
        l2.add(laptop3);
        l2.add(laptop4);
        student2.setLaptops(l2);
//        student1.set
//        
//        List<Laptop> l1 = new ArrayList<Laptop>();
//        l1.add(laptop1);

        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(student4);
    }

    public static void updateData(EntityManager em, Long id) {
        // Option 1:
//        Student st = em.find(Student.class, id);
//        em.merge(st);
        // Option 2:
        Student st = new Student();
        st.setId(id);
        st.setGpa(4.0D);
        st.setName("Updated of By Merged");
        em.merge(st);
    }

    public static void removeData(EntityManager em, Long id) {
//        Student st = em.find(Student.class, id);
//        em.remove(st);
        em.remove(null);
    }

    public static void testing(EntityManager em, Long id) {
        try {
            Student st = em.find(Student.class, 20L);
            System.out.println("Student with id - 20: " + st);

            String queryStr = "SELECT s FROM Student s";
            CriteriaBuilder criBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Student> criQuery = criBuilder.createQuery(Student.class);
            Root<Student> root = criQuery.from(Student.class);
            criQuery.select(root);
            TypedQuery<Student> query = em.createQuery(criQuery);
            List<Student> students = query.getResultList();
        } catch (Exception e) {
        }
    }

    public static void testing1(EntityManager em) {
        String str = "SELECT s FROM Student s WHERE s.gpa = 3.0";
        CriteriaBuilder criBuilder = em.getCriteriaBuilder();
        CriteriaQuery criQuery = criBuilder.createQuery(Student.class);
        Root<Student> root = criQuery.from(Student.class);
        criQuery.select(root);
        Predicate gpaPredicate = criBuilder.equal(root.get("gpa"), 3.0);
        criQuery.where(gpaPredicate);
        TypedQuery<Student> query = em.createQuery(criQuery);
        List<Student> students = query.getResultList();
    }

    public static void testing2(EntityManager em) {
        String str = "SELECT s FROM Student s WHERE s.gpa=3.0 AND s.laptop.ram= 8";
        CriteriaBuilder criBuilder = em.getCriteriaBuilder();
        CriteriaQuery criQuery = criBuilder.createQuery(Student.class);
        Root<Student> root = criQuery.from(Student.class);
        criQuery.select(root);

        Predicate gpaPredicate = criBuilder.equal(root.get("gpa"), 3.0);
        Join<Student, Laptop> joinLaptop = root.join("laptop");
        Predicate ramPredicate = criBuilder.equal(joinLaptop.get("ram"), 8);
        Predicate andPredicate = criBuilder.and(gpaPredicate, ramPredicate);
        criQuery.where(andPredicate);

        TypedQuery<Student> query = em.createQuery(criQuery);
        List<Student> students = query.getResultList();

    }

    public static void getStudentHaveLaptopWithHarddisk(EntityManager em){
        String str = "Select l from Student s Join Laptop l where l.harddisk = '501TB'";
        CriteriaBuilder criBuilder = em.getCriteriaBuilder();
        CriteriaQuery criQuery = criBuilder.createQuery();
        Root<Student> root = criQuery.from(Student.class);
        criQuery.select(root);
        Join<Student, Laptop> joinLaptop = root.join("laptops");
        Predicate harddiskPredicate = criBuilder.greaterThan(joinLaptop.get("harddisk"), "501TB");
        criQuery.where(harddiskPredicate);
        criQuery.distinct(true);
        TypedQuery<Student> query = em.createQuery(criQuery);
        List<Student> students = query.getResultList();
        
        students.forEach(e -> System.out.println(e));
    }
    
    public static void getAllLaptopOfStudent(EntityManager em){
        String str = "Select s.laptops from Student s where s.gpa >= 3.2 and s.laptops != null";
        TypedQuery<Laptop> query = em.createQuery(str, Laptop.class);
        List<Laptop> laptops = query.getResultList();
        laptops.forEach(e -> System.out.println(e));        
    }
}
