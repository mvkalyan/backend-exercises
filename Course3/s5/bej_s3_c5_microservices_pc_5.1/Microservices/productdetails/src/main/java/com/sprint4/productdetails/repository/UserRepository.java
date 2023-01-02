package com.sprint4.productdetails.repository;

import com.sprint4.productdetails.model.Product;
import com.sprint4.productdetails.model.UserProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserProduct,String>{
    public Product findUserByUserEmail(String email);
}
