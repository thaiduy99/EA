/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.scheduling;

import java.time.LocalDateTime;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * @author Thai Nguyen
 */
public class MySchedule {    
//    @Scheduled(fixedDelay = 5000, initialDelay = 2000)
    @Scheduled(cron="0/5 * * * * *")
    public void printTimer() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("***********LocalDateTime is " + now);
    }
    
}
