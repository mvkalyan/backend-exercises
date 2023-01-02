package com.niit.Course13Sprint1.respository;

import com.niit.Course13Sprint1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    public List<Employee> findByName(String name);

}

