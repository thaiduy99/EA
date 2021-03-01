/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author Thai Nguyen
 */
@Entity
public class CPTStudent extends Student implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String job;
    private Integer salary;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.job);
        hash = 43 * hash + Objects.hashCode(this.salary);
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
        final CPTStudent other = (CPTStudent) obj;
        if (!Objects.equals(this.job, other.job)) {
            return false;
        }
        if (!Objects.equals(this.salary, other.salary)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CPTStudent{" + "name=" + this.getName() + ", gpa=" + this.getGpa()+ ", job=" + job + ", salary=" + salary + '}';
    }   
    
}
