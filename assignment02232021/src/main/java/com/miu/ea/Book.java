/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Thai Nguyen
 */
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title; 
    private Integer numPage;
    
//    case 1: Both Student knows Book and Book know Student
    @OneToOne
    @JoinColumn
    private Student student;
    
//    case 2: Student knows Book but Book do not know Student
//    private Student student;
    
//    case 3: Student owns several book
//    @ManyToOne
//    @JoinColumn(name = "STUDENTID")
//    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumPage() {
        return numPage;
    }

    public void setNumPage(Integer numPage) {
        this.numPage = numPage;
    }

    
//    case 3: Student knows many books
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

//    case 1
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
        if (student.getBook() == null)
            student.setBook(this);
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", numPage=" + numPage + '}';
    }
    
}
