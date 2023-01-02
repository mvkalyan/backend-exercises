package com.niit.course13Sprint4.service;

import com.niit.course13Sprint4.exception.CustomerAlreadyExistingException;
import com.niit.course13Sprint4.exception.CustomerNotFoundException;
import com.niit.course13Sprint4.model.Customer;

import java.util.List;

public interface ICustomerService {

    public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistingException;
    public List<Customer> getAllCustomer();
    public boolean deleteCustomer(int customerId) throws CustomerNotFoundException;
    public Customer updateCustomer(Customer customer,int customerId) throws CustomerNotFoundException;
    public List<Customer> findAllCustomerByCustomerName(String name);

    public List<Customer> findALlCustomerByCity(String city);
}
