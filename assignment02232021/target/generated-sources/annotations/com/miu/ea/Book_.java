package com.miu.ea;

import com.miu.ea.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-25T17:01:53")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Student> student;
    public static volatile SingularAttribute<Book, Long> id;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile SingularAttribute<Book, Integer> numPage;

}