package com.niit.userauthenticationservice.service;


import com.niit.userauthenticationservice.domain.Customer;
import com.niit.userauthenticationservice.exception.CredentialsException;
import com.niit.userauthenticationservice.exception.RegisteredException;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomer();

    Customer saveCustomer(Customer customer) throws RegisteredException;

    Customer findCustomerByCustomerIdAndPassword(String customerId, String password) throws CredentialsException;



}
