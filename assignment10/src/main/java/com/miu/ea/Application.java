/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea;

import com.miu.ea.business.AccountEntry;
import com.miu.ea.scheduling.MySchedule;
import com.miu.ea.service.AccountService;
import com.miu.ea.service.StudentService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * @author Thai Nguyen
 */
@Configuration
//@EnableScheduling
@EnableAsync
@ComponentScan("com.miu.ea") 
public class Application {

    @Autowired
    private AccountService accService;
    
    @Autowired
    private StudentService stuService;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        Application app = context.getBean(Application.class);
        app.testInsertAccountEntry();
        app.testInsertStudentCourseAndTranscript();
    }
    
    public void testInsertAccountEntry(){
        System.out.println("testInsertAccountEntry");
        System.out.println("AccountService: " + accService);
        AccountEntry ae = new AccountEntry();
        ae.setAccountNumber("641345A03");
        ae.setAmount(200.5D);
        ae.setTransactionDate(LocalDate.now());
        accService.insertAccountEntry(ae);
    }
    
    public void testInsertStudentCourseAndTranscript(){
        stuService.insertStudentCourseAndTranscript();
    }
    
    @Bean
    public MySchedule getSchedule(){
        return new MySchedule();
    }
}
