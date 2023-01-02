package org.niit;

import org.niit.Domain.Employee;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean("emp1")// <bean id="emp1"
    public Employee getEmployee(){
        return new Employee(1,"jhon","abc");
    }
    @Bean("emp2")// <bean id="emp2"
    public Employee getEmployee2(){
        return new Employee(2,"jhon1","abc1");
    }
}
