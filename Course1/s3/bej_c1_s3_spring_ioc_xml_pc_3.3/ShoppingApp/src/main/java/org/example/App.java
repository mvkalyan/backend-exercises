package org.example;

import org.example.domain.Customer;
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
        Customer c1=(Customer)acObj.getBean("Customer1");
        System.out.println(c1);
        Customer c2=(Customer) acObj.getBean("Customer2");
        System.out.println(c2);
    }
}
