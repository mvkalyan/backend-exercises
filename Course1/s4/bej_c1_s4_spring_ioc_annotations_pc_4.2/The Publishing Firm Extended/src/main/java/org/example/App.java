package org.example;

import org.example.domain.Author;
import org.example.domain.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appObj=new AnnotationConfigApplicationContext(AppCnfg.class);
        Book b1=(Book) appObj.getBean("Book1");
        Book b2=(Book) appObj.getBean("Book2");

//        Author a1=(Author) appObj.getBean("Auth1");
//        Author a2=(Author) appObj.getBean("Auth2");

        System.out.println(b1+"\n"+b2);
    }
}
