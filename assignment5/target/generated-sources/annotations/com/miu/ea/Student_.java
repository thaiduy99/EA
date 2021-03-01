package com.miu.ea;

import com.miu.ea.Laptop;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-28T09:22:10")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> name;
    public static volatile SingularAttribute<Student, Double> gpa;
    public static volatile SingularAttribute<Student, Long> id;
    public static volatile ListAttribute<Student, Laptop> laptops;

}