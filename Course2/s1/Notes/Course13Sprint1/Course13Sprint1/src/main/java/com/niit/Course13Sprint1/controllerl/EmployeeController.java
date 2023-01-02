package com.niit.Course13Sprint1.controllerl;
import com.niit.Course13Sprint1.model.Employee;
import com.niit.Course13Sprint1.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;


    public EmployeeController(IEmployeeService iEmployeeService){
        this.iEmployeeService=iEmployeeService;
    }

    @PostMapping("/employee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee emp){

        return new ResponseEntity<>(iEmployeeService.save(emp), HttpStatus.CREATED);
    }

    @GetMapping("/employee")
    public ResponseEntity<?> getAllEmployee(){

        return new ResponseEntity<>(iEmployeeService.getAllEmployee(),HttpStatus.OK);

    }


}
