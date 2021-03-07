/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.dao;

import com.miu.ea.business.Course;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thai Nguyen
 */
@Repository
public class CoursePersistence {

    public int save(Course course) {
        try {
            EntityManager em = JPA_Util.getEntityManager();
            em.persist(course);
        } catch (Exception ex) {
            return -1;
        }

        return 1;
    }
}
