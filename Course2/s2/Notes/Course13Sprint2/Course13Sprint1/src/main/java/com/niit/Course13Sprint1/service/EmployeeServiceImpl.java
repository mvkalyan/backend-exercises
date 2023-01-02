package com.niit.Course13Sprint1.service;

import com.niit.Course13Sprint1.model.Employee;
import com.niit.Course13Sprint1.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;

    }
    @Override
    public Employee save(Employee e) {
        return employeeRepository.save(e) ;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>)employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public String deleteById(int id) {

        if(employeeRepository.findById(id).isEmpty()){
            return "Employee does not exist";

        }
       employeeRepository.deleteById(id);
       return "deleted succefully";
    }


}
