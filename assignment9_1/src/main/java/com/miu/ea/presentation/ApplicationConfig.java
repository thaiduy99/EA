/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.presentation;

import com.miu.ea.dao.StudentPersister;
import com.miu.ea.service.PersistenceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @author Thai Nguyen
 */
@Configuration
@ComponentScan("com.miu.ea")
@EnableAspectJAutoProxy
public class ApplicationConfig {
    @Bean
    public PersistenceService persistenceService(){
        PersistenceService ps = new PersistenceService();
        ps.setStudentPersister(studentPersister());
        return ps;
    }
    @Bean
    public StudentPersister studentPersister() {
        return new StudentPersister();
    }   
}
