/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea;

import com.miu.ea.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Thai Nguyen
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        StudentPersister sp = context.getBean("persister", StudentPersister.class);
        Student st = new Student();
        st.setName("Thai Nguyen");
        st.setGpa(3.7D);
        st.setNation("Vietnam");
//        sp.insertStudent(st);
        sp.insertStudentByAuthowired(st);
    }
}
