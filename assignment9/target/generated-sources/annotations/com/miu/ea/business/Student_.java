package com.miu.ea.business;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-03T20:57:28")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> name;
    public static volatile SingularAttribute<Student, Double> gpa;
    public static volatile SingularAttribute<Student, Long> id;
    public static volatile SingularAttribute<Student, LocalDate> startdate;

}