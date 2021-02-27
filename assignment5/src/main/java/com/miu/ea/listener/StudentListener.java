/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.listener;

import com.miu.ea.Student;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

/**
 *
 * @author Thai Nguyen
 */
public class StudentListener {
    @PostPersist   
    public void doForPersist(Student student){
        System.out.println("Hi " + student.getName() + "!");
        System.out.println("Welcome to MIU");
    }
    
    @PostUpdate   
    public void doForUpdate(Student student){
        System.out.println("Your information is updated!");
    }
}
