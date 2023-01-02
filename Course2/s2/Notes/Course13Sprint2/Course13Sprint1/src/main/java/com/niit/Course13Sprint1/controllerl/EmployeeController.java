package com.niit.Course13Sprint1.controllerl;
import com.niit.Course13Sprint1.model.Employee;
import com.niit.Course13Sprint1.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;


    public EmployeeController(IEmployeeService iEmployeeService){
        this.iEmployeeService=iEmployeeService;
    }
//http://localhost:8082/api/v1/employee
    @PostMapping("/employee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee emp){

        return new ResponseEntity<>(iEmployeeService.save(emp), HttpStatus.CREATED);
    }

    @GetMapping("/employee")
    public ResponseEntity<?> getAllEmployee(){

        return new ResponseEntity<>(iEmployeeService.getAllEmployee(),HttpStatus.OK);

    }

    //http://localhost:8082/api/v1/employee/abc
    @GetMapping("/employee/{name}")
    public ResponseEntity<?> findAllEmployeeWithName(@PathVariable String name){
        return new ResponseEntity<>(iEmployeeService.findByName(name),HttpStatus.OK);

    }
    //http://localhost:8082/api/v1/employee/101
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        return new ResponseEntity<>(iEmployeeService.deleteById(id),HttpStatus.OK);
    }




}
