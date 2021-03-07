/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.dao;

import com.miu.ea.business.AccountEntry;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thai Nguyen
 */
@Repository
public class AccountEntryPersistence {
    public int save(AccountEntry accountEntry){
        System.out.println("Start to insert into Account Entry");
        try{
            EntityManager em = JPA_Util.getEntityManager();
            em.persist(accountEntry);
        } catch(Exception ex){
            return -1;
        }
        System.out.println("End to insert into Account Entry");
        return 1;
    }
    
    public int saveWithCommit(AccountEntry accountEntry){
        
        try{
            EntityManager em = JPA_Util.getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(accountEntry);
            tx.commit();
        } catch(Exception ex){
            return -1;
        }
        System.out.println("End to insert into Account Entry");
        return 1;
    }
}
