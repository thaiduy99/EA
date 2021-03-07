/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.service;

import com.miu.ea.business.AccountEntry;
import com.miu.ea.dao.AccountEntryPersistence;
import com.miu.ea.dao.JPA_Util;
import com.miu.ea.dao.LogPersistence;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thai Nguyen
 */
@Service
public class AccountService {

    @Autowired
    private AccountEntryPersistence aePersistence;
    @Autowired
    private LogPersistence logPersistence;

    public int insertAccountEntry(AccountEntry ae) {
        try {
            EntityTransaction tx = JPA_Util.getEntityManager().getTransaction();
//            tx.begin();
//            aePersistence.save(ae);
//            logPersistence.addLogOfAccountEntry("Insert");
            aePersistence.saveWithCommit(ae);
            logPersistence.addLogOfAccountEntryWithCommit("Insert");
            System.out.println("End to insert into two tables, AccountEntry and Log");
//            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
        System.out.println("End of Service");
        return 1;
    }   
   
}
