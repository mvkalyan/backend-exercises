package org.niit;

import org.niit.Domain.Employee;
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
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
         Employee e1=(Employee) applicationContext.getBean("emp1");
        System.out.println("Employee "+e1.getFirstname());
        Employee e2=(Employee) applicationContext.getBean("emp2");
        System.out.println("Employee "+e2);

    }
}
