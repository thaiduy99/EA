/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;

/**
 *
 * @author Thai Nguyen
 */
@Entity
public class JobSearchStudent extends Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private String resume;
    private LocalDate startJobSearchDate;

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
    public String toString() {
        return "JobSearchStudent{" + "name=" + this.getName() + ", gpa=" + this.getGpa() + ", resume=" + resume + ", startJobSearchDate=" + startJobSearchDate + '}';
    }
}
