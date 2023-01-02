package com.niit.usermovieservice.repository;

import com.niit.usermovieservice.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProductRepository extends MongoRepository<Customer,String> {

    // custom method to find customer by email
    Customer findByEmail(String email);
}
