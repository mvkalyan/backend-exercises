package com.niit.userauthenticationservice.controller;

import com.niit.userauthenticationservice.domain.Customer;
import com.niit.userauthenticationservice.exception.CredentialsException;
import com.niit.userauthenticationservice.exception.RegisteredException;
import com.niit.userauthenticationservice.security.TokenGenerator;
import com.niit.userauthenticationservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/app/shopping")
public class CustomerController {

    private CustomerService customerService;
    private TokenGenerator securityTokenGenerator;

    @Autowired
    public CustomerController(CustomerService customerService, TokenGenerator securityTokenGenerator) {
        this.customerService = customerService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    //getting id & password for all customers
    @GetMapping("/customer")
    public ResponseEntity<?> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.FOUND);
    }

    //registering customer
    @PostMapping("/register")
    public ResponseEntity<?> save(@RequestBody Customer customer) throws RegisteredException {
        return new ResponseEntity<>(customerService.saveCustomer(customer),HttpStatus.CREATED);
    }

    //logging customer in and generating token
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Customer customer) throws CredentialsException
    {
        //checking weather customer provided id and password in is the database
        //if is there, we will get object of it
        Customer obj = customerService.findCustomerByCustomerIdAndPassword(customer.getCustomerId(),customer.getPassword());

        //if obj==null it means user is not registered before and no authenticated
        if(obj!=null)
        {
            //if obj!=null it means user is registered before and authenticated
            //we can generate token now using JWT token generator and return key-value pair of token
            Map<String,String> map = securityTokenGenerator.tokenGenerator(customer);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        else
        {
            //customer is unauthorized
            throw new CredentialsException();
        }
    }
}
