package com.miu.ea;

import com.miu.ea.Book;
import com.miu.ea.Course;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-25T17:01:53")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> studentID;
    public static volatile ListAttribute<Student, Course> courses;
    public static volatile SingularAttribute<Student, Double> grade;
    public static volatile SingularAttribute<Student, Book> book;
    public static volatile SingularAttribute<Student, String> name;
    public static volatile SingularAttribute<Student, Long> id;

}