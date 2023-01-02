package com.niit.course13Sprint4.controller;

import com.niit.course13Sprint4.exception.CustomerAlreadyExistingException;
import com.niit.course13Sprint4.exception.CustomerNotFoundException;
import com.niit.course13Sprint4.model.Customer;
import com.niit.course13Sprint4.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerdata")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    //http://localhost:65100/customerdata/customer  --- POST
    @PostMapping("/customer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistingException {
        try {
            return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
        } catch (CustomerAlreadyExistingException e) {
            System.out.println(e);
            throw new CustomerAlreadyExistingException();
        }
    }

    @GetMapping("/customer")
    public ResponseEntity<?> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.FOUND);
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable int customerId)throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.deleteCustomer(customerId),HttpStatus.OK);

    }

    @PutMapping("/customer/{customerId}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer,@PathVariable int customerId) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.updateCustomer(customer,customerId),HttpStatus.OK);
    }


    @GetMapping("/customer/{name}")
    public ResponseEntity<?> getCustomersByName(@PathVariable String name){
        return new ResponseEntity<>(customerService.findAllCustomerByCustomerName(name),HttpStatus.FOUND);
    }
    @GetMapping("/customers/{city}")
    public ResponseEntity<?> getCustomerByCity(@PathVariable String city){
        return new ResponseEntity<>(customerService.findALlCustomerByCity(city),HttpStatus.FOUND);
    }

}
