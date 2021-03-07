/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.service;

import com.miu.ea.business.Course;
import com.miu.ea.business.Student;
import com.miu.ea.business.Transcript;
import com.miu.ea.dao.CoursePersistence;
import com.miu.ea.dao.JPA_Util;
import com.miu.ea.dao.StudentPersistence;
import com.miu.ea.dao.TranscriptPersistence;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thai Nguyen
 */
@Service
public class StudentService {
    @Autowired
    private StudentPersistence sp;
    @Autowired
    private CoursePersistence cp;
    @Autowired
    private TranscriptPersistence tp;
    
     public int insertStudentCourseAndTranscript(){
         try {
            EntityTransaction tx = JPA_Util.getEntityManager().getTransaction();
            tx.begin();
            // insert Student
            Student s1 = new Student();
            s1.setName("Thai Nguyen");
            s1.setStudentNum(611524);
            s1.setGpa(3.68D);
            sp.save(s1);
            
            Student s2 = new Student();
            s2.setName("Phuoc Doan");
            s2.setStudentNum(611513);
            s2.setGpa(3.50D);
            sp.save(s2);
            
            Student s3 = new Student();
            s3.setName("Hanh Nguyen");
            s3.setStudentNum(611501);
            s3.setGpa(3.8D);
            sp.save(s3);
            
            // Insert Course
            Course c1 = new Course();
            c1.setName("Modern Programming Principles");
            c1.setShortName("MPP");
            c1.setCredit(4);
            cp.save(c1);
            
            Course c2 = new Course();
            c2.setName("Web Application Programming");
            c2.setShortName("WAP");
            c2.setCredit(4);
            cp.save(c2);
            
            Course c3 = new Course();
            c3.setName("Advance Software Development");
            c3.setShortName("ASD");
            c3.setCredit(4);
            cp.save(c3);
            
            Course c4 = new Course();
            c4.setName("Wab Application Architecture");
            c4.setShortName("WAA");
            c4.setCredit(4);
            cp.save(c4);
            
            
            Course c5 = new Course();
            c5.setName("Algorithm");
            c5.setShortName("Ago");
            c5.setCredit(4);
            cp.save(c5);
            
            
            Course c6 = new Course();
            c6.setName("Big Data Technology");
            c6.setShortName("BDT");
            c6.setCredit(4);
            cp.save(c6);
            
            
            // Insert Transcript
            Transcript t1 = new Transcript();
            t1.setStudent(s1);
            t1.setCourse(c1);
            t1.setGrade(4.0D);
            tp.save(t1);
            
            Transcript t2 = new Transcript();
            t2.setStudent(s1);
            t2.setCourse(c2);
            t2.setGrade(3.0D);
            tp.save(t2);
            
            Transcript t3 = new Transcript();
            t3.setStudent(s1);
            t3.setCourse(c3);
            t3.setGrade(3.6D);
            tp.save(t3);
            
            Transcript t4 = new Transcript();
            t4.setStudent(s1);
            t4.setCourse(c4);
            t4.setGrade(4.0);
            tp.save(t4);
            
            Transcript t5 = new Transcript();
            t5.setStudent(s2);
            t5.setCourse(c1);
            t5.setGrade(3.0);
            tp.save(t5);
            
            Transcript t6 = new Transcript();
            t6.setStudent(s2);
            t6.setCourse(c2);
            t6.setGrade(3.6D);
            tp.save(t6);
            
            Transcript t7 = new Transcript();
            t7.setStudent(s2);
            t7.setCourse(c6);
            t7.setGrade(4.0D);
            tp.save(t7);
            
            Transcript t8 = new Transcript();
            t8.setStudent(s2);
            t8.setCourse(c3);
            t8.setGrade(3.6D);
            tp.save(t8);
            
            tx.commit();
        } catch (Exception e) {
            return -1;
        }
        System.out.println("End of Service");
        return 1;
    }
}
