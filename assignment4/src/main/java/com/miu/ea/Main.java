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

/**
 *
 * @author Thai Nguyen
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("assignment4");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        insertData(em);
        getAllBooksByGPA(em, 3.0);
        getAllBooksPageMoreThan(em, 100, 3.0);
        getAllStudentByGPA(em, 3.0);
        
        tx.commit();
        em.close();
        emf.close();
    }
    
    public static void insertData(EntityManager em){
        //Student, Book, Author, Puplisher
        Address add = new Address();
        add.setCity("New York");
        add.setState("WashingtonDC");
        add.setStreet("Wall street");
        add.setZip(10001);
        Author author = new Author();
        author.setName("Stephen Hawking");
        author.setAddress(add);
        
        Address add1 = new Address();
        add1.setCity("Fairfied");
        add1.setState("Iowa");
        add1.setStreet("The N. 4th street");
        add1.setZip(52557);     
        Author author1 = new Author();
        author1.setName("Jack Canfield");
        author1.setAddress(add1);
        
        Publisher publisher = new Publisher();
        publisher.setName("Chicken Soup for the Soul, LLC");
        publisher.setNumOfEmployee(100);
        
        Publisher publisher1 = new Publisher();
        publisher1.setName("New York Time");
        publisher1.setNumOfEmployee(1979);
        
        Book book = new Book();
        book.setAuthor(author);
        book.setPublisher(publisher1);
        book.setTitle("A Brief History of Time");
        book.setPage(755);
        
        Book book1 = new Book();
        book1.setAuthor(author);
        book1.setPublisher(publisher1);
        book1.setTitle("The Theory of Everything");
        book1.setPage(599);
        
        Book book2 = new Book();
        book2.setAuthor(author1);
        book2.setPublisher(publisher);
        book2.setTitle("Where there's a wheel there's a way");
        book2.setPage(92);
        
        Book book3 = new Book();
        book3.setAuthor(author1);
        book3.setPublisher(publisher);
        book3.setTitle("What I Learned From the Dog");
        book3.setPage(200);
        
        Student student1 = new Student();
        student1.setName("Thai Nguyen");
        student1.setGpa(3.68);
       
        List<Book> lb = new ArrayList<>();
        lb.add(book);
        book.setStudent(student1);
        lb.add(book1);
        book1.setStudent(student1);
        lb.add(book2);
        book2.setStudent(student1);
        student1.setBooks(lb);
        
        Student student2 = new Student();
        student2.setName("Tien Pham");
        student2.setGpa(3.8);
        List<Book> lb1 = new ArrayList<>();
        lb1.add(book3);
        book3.setStudent(student2);
        student2.setBooks(lb1);    
        
        Student student3 = new Student();
        student3.setName("Phuoc Doan");
        student3.setGpa(4.0);
        
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
    }
    
    public static void getAllStudentByGPA(EntityManager em, Double gpa){
        Query namedQuery = em.createNamedQuery("Student.findStudentByGPA");
        namedQuery.setParameter("gpa", gpa);
        List<Student> students = namedQuery.getResultList();
        System.out.println("***************************All Students with GPA >= 3.0***********************************");
        students.forEach(s -> System.out.println(s.getBooks().size()));
        System.out.println("***************************************************************************************************");
    }

    //    1- Write a named query to return all books for a students with gpa >= 3.0.
    public static void getAllBooksByGPA(EntityManager em, Double gpa){
        Query namedQuery = em.createNamedQuery("Book.findBookByStudentWithGPA");
        namedQuery.setParameter("gpa", gpa);
        List<Book> books = namedQuery.getResultList();
        System.out.println("***************************All Books of Students with GPA >= 3.0***********************************");
        books.forEach(b -> System.out.println(b));
        System.out.println("***************************************************************************************************");
    }
    
    //    2- Write a native query to return all book with >= 100 pages for students with gpa >= 3.0.
    public static void getAllBooksPageMoreThan(EntityManager em, Integer page, Double gpa){
        TypedQuery<Book> query = em.createNamedQuery("Student.native.GetAllBooksByPageAndGPA", Book.class);
        query.setParameter(1, gpa);
        query.setParameter(2, page);
        List<Book> books = query.getResultList();
        System.out.println("***************************All Books of Students with GPA >= 3.0, and Pages >= 100***********************************");
        books.forEach(b -> System.out.println(b));
        System.out.println("*********************************************************************************************************************");
    }
    
    //    3 - find the book with pages more than or equal to 120 pages and belonging to students with gpa >= 3.0 and written by an Author living in Iowa, and the book is published by a publisher with more than 100 employees
    public static void getAllBooksByPageAndGPAAndAuthorAndPublisher(EntityManager em, Integer page, Double gpa, String state, Integer empNum){
        String str = "Select s.books from Student s";
        
        
        TypedQuery<Book> query = em.createNamedQuery("Student.native.GetAllBooksByPageAndGPA", Book.class);
        query.setParameter(1, gpa);
        query.setParameter(2, page);
        List<Book> books = query.getResultList();
        System.out.println("***************************All Books of Students with GPA >= 3.0, and Pages >= 100***********************************");
        books.forEach(b -> System.out.println(b));
        System.out.println("*********************************************************************************************************************");
    }
    
}
