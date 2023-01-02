package com.niit.Course13Sprint1.service;

import com.niit.Course13Sprint1.model.Employee;

import java.util.List;

public interface IEmployeeService {

    public Employee save(Employee e);
    public List<Employee> getAllEmployee();
}
