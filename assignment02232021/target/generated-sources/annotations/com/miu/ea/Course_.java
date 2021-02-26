package com.miu.ea;

import com.miu.ea.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-25T17:01:53")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, String> name;
    public static volatile SingularAttribute<Course, Long> id;
    public static volatile SingularAttribute<Course, String> shortName;
    public static volatile ListAttribute<Course, Student> register;

}