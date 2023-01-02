package org.example;

import org.example.domain.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext acObj=new ClassPathXmlApplicationContext("beans.xml");
        Product p1=(Product)acObj.getBean("product");
        System.out.println(p1);
    }
}
