/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.presentation;

import com.miu.ea.business.Student;
import com.miu.ea.service.PersistenceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Thai Nguyen
 */

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        
        Student student = new Student();
        student.setFirstname("Nhat Minh");
        student.setLastname("Nguyen Ngoc");
        student.setGpa(3.7D);
        PersistenceService ps = context.getBean("persistenceService", PersistenceService.class);
        ps.insertStudent(student);
    }   
}
