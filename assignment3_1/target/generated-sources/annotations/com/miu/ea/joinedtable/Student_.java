package com.miu.ea.joinedtable;

import com.miu.ea.joinedtable.Laptop;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-25T00:46:20")
@StaticMetamodel(Student.class)
public abstract class Student_ { 

    public static volatile SingularAttribute<Student, String> name;
    public static volatile SingularAttribute<Student, Double> gpa;
    public static volatile SingularAttribute<Student, Long> id;
    public static volatile SingularAttribute<Student, Laptop> laptop;

}