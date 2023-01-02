package org.niit;

import org.niit.Config.AppConfig;
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
        Employee e1=applicationContext.getBean("emp1",Employee.class);
        System.out.println( "Employee "+e1);
    }
}
