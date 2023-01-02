package com.niit.course13Sprint4.respoitory;

import com.niit.course13Sprint4.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {
    // will get from mongorepo
    //custom methods
    //get all customer with name
    public List<Customer> findAllCustomerByCustomerName(String name);

    //get customer by city name--> city is not direct member of customer--> its a member address
    //need to use @Query()

    //@Query("{city:{$eq:?0}}") //select * from Customer where city=?

    @Query("{'address.city':{$eq:?0}}")//
    public List<Customer> findAllCustomerByCity(String city);

}
