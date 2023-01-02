package com.niit.userauthenticationservice.service;


import com.niit.userauthenticationservice.domain.Customer;
import com.niit.userauthenticationservice.exception.CredentialsException;
import com.niit.userauthenticationservice.exception.RegisteredException;
import com.niit.userauthenticationservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) throws RegisteredException {
        if(customerRepository.findById(customer.getCustomerId()).isPresent())
        {
            throw new RegisteredException();
        }
        //System.out.println(customer);
        return customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerByCustomerIdAndPassword(String customerId, String password) throws CredentialsException {
        //System.out.println("email"+customerId);
        //System.out.println("password"+password);
        Customer loggedInCustomer = customerRepository.findCustomerByCustomerIdAndPassword(customerId,password);
        //System.out.println(loggedInUser);
        if(loggedInCustomer == null)
        {
            throw new CredentialsException();
        }

        return loggedInCustomer;
    }
}
