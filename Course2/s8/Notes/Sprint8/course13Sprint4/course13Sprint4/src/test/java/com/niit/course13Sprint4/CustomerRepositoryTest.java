package com.niit.course13Sprint4;

import com.niit.course13Sprint4.model.Address;
import com.niit.course13Sprint4.model.Customer;
import com.niit.course13Sprint4.respoitory.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerRepositoryTest {


    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;
    private Address address;

    @BeforeEach
    public void setUp(){
        address=new Address(440111,"JM Road","Mumbai");
        customer=new Customer(200,"Ankit",address);
    }

    @AfterEach
    public void clear(){
        address=null;
        customer=null;
    }

    @Test
    public void givenCustomerDetailsToReturnCustomer(){
        //insert record
        customerRepository.insert(customer);
        //get record by id
        Customer c=customerRepository.findById(customer.getCustomerId()).get();
        //assertEquals(c.getCustomerName(),customer.getCustomerName());
        //  Assertions.assertEquals(c.getCustomerName(),customer.getCustomerName());
        // //compare values for both object need to override equalmethod
            assertEquals(c,customer);
    }

    @Test
    public void getAllCustomer(){
        customerRepository.insert(customer);
        List<Customer>  list=customerRepository.findAll();
        assertEquals(2,list.size());
    }

    @Test
    public void givenCustomerToDelete(){
        customerRepository.insert(customer);
        customerRepository.deleteById(customer.getCustomerId());
        assertEquals(Optional.empty(),customerRepository.findById(customer.getCustomerId()));
    }



}
