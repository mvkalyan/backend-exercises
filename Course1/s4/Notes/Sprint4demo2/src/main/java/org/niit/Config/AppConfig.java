package org.niit.Config;

import org.niit.Domain.Address;
import org.niit.Domain.Employee;
import org.springframework.context.annotation.Bean;

public class AppConfig {


    @Bean("add1")
    public Address getAddress(){
        return new Address(441100,"H101","Mumbai","MH");
    }

    @Bean("emp1")
    public Employee getEmp(){
        return new Employee(101,"Abc","ASD");
    }



}
