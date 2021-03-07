/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.presentation;

import com.miu.ea.business.Student;
import com.miu.ea.service.PersistenceService;
import java.time.LocalDate;
import java.time.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Thai Nguyen
 */
@Configuration
@ComponentScan("com.miu.ea")
public class Application {

    @Autowired
    private PersistenceService ps;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        Application app = context.getBean(Application.class);
        app.testInsert();
    }
    
    public void testInsert(){
        Student student = new Student();
        student.setName("Thai Nguyen");
        student.setGpa(3.7D);
        student.setStartdate(LocalDate.of(2020, Month.AUGUST, 5));
        ps.insertStudent(student);
    }
}
