package com.niit.userauthenticationservice.repository;


import com.niit.userauthenticationservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {

    //custom method handler to check customer is authenticated
    Customer findCustomerByCustomerIdAndPassword(String customerId, String password);
}
