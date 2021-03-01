/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.singletable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Thai Nguyen
 */
@Entity
@DiscriminatorValue("Job")
public class JobSearchStudent extends Student implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
    private String resume;
    private LocalDate startJobSearchDate;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public LocalDate getStartJobSearchDate() {
        return startJobSearchDate;
    }

    public void setStartJobSearchDate(LocalDate startJobSearchDate) {
        this.startJobSearchDate = startJobSearchDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.resume);
        hash = 83 * hash + Objects.hashCode(this.startJobSearchDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JobSearchStudent other = (JobSearchStudent) obj;
        if (!Objects.equals(this.resume, other.resume)) {
            return false;
        }
        if (!Objects.equals(this.startJobSearchDate, other.startJobSearchDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JobSearchStudent{" + "name=" + this.getName() + ", gpa=" + this.getGpa() + ", resume=" + resume + ", startJobSearchDate=" + startJobSearchDate + '}';
    }   
    
}
