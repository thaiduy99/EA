/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.app;

import com.miu.ea.model.Student;
import com.miu.ea.service.PersistenceService;
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
public class Application {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        Application app = new Application();
        app.testInsert(context);
    }

    public void testInsert(ApplicationContext context) {
        PersistenceService service = context.getBean("persistenceService", PersistenceService.class);
        System.out.println(service);
        Student student = new Student();
        student.setName("Thai Nguyen");
        student.setNation("Vietnam");
        student.setGpa(3.7D);
        service.saveStudent(student);
    }
}
