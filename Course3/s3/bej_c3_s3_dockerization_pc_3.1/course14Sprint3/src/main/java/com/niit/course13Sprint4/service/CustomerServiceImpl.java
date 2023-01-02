package com.niit.course13Sprint4.service;

import com.niit.course13Sprint4.exception.CustomerAlreadyExistingException;
import com.niit.course13Sprint4.exception.CustomerNotFoundException;
import com.niit.course13Sprint4.model.Customer;
import com.niit.course13Sprint4.respoitory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer)throws CustomerAlreadyExistingException {

        //if not exits
        if(customerRepository.findById(customer.getCustomerId()).isEmpty()){
           // return customerRepository.save(customer);//it update record if it exit
            return customerRepository.insert(customer);// insert only if record is not exit
        }else{//if alredy exit
            // return CustomerAlredyExist
            throw new CustomerAlreadyExistingException();
        }
    }
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public boolean deleteCustomer(int customerId) throws CustomerNotFoundException {

        //if customer is not exist
        if(customerRepository.findById(customerId).isEmpty()){
            //Customer not found
            throw new CustomerNotFoundException();
        }
        customerRepository.deleteById(customerId);
        return true;
    }

    @Override
    public Customer updateCustomer(Customer customer,int id) throws CustomerNotFoundException {
        if(customerRepository.findById(customer.getCustomerId()).isEmpty()){
            throw new CustomerNotFoundException();
        }else{
            customerRepository.save(customer);
            return customer;
        }
    }

    @Override
    public List<Customer> findAllCustomerByCustomerName(String name) {
        return customerRepository.findAllCustomerByCustomerName(name);
    }

    @Override
    public List<Customer> findALlCustomerByCity(String city) {
        return customerRepository.findAllCustomerByCity(city);
    }

}
