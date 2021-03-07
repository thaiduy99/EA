/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.dao;

import com.miu.ea.business.Log;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thai Nguyen
 */
@Repository
public class LogPersistence {
    @Async
    public void addLogOfAccountEntry(String action) {
        System.out.println("Start to insert into Log Entity");
        try {
            Thread.sleep(10000);
            Log log = new Log();
            log.setMessage(action);
            log.setCreatedDate(LocalDate.now());
            EntityManager em = JPA_Util.getEntityManager();
            em.persist(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End to insert into Log Entity");
    }
    
    @Async
    public void addLogOfAccountEntryWithCommit(String action) {
        try {
            Thread.sleep(10000);
            Log log = new Log();
            log.setMessage(action);
            log.setCreatedDate(LocalDate.now());
            EntityManager em = JPA_Util.getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(log);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
