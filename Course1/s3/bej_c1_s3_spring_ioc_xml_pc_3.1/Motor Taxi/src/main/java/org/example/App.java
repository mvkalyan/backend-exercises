package org.example;

import org.example.domain.Cab;
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
        Cab c1=(Cab)acObj.getBean("Cab1");
        System.out.println(c1);
        Cab c2=(Cab) acObj.getBean("Cab2");
        System.out.println(c2);
    }
}
