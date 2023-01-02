package com.niit.Course13Sprint1.respository;

import com.niit.Course13Sprint1.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}

