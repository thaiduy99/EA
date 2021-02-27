package com.miu.ea;

import com.miu.ea.Author;
import com.miu.ea.Publisher;
import com.miu.ea.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T21:19:52")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Student> student;
    public static volatile SingularAttribute<Book, Author> author;
    public static volatile SingularAttribute<Book, Publisher> publisher;
    public static volatile SingularAttribute<Book, Long> id;
    public static volatile SingularAttribute<Book, Integer> page;
    public static volatile SingularAttribute<Book, String> title;

}