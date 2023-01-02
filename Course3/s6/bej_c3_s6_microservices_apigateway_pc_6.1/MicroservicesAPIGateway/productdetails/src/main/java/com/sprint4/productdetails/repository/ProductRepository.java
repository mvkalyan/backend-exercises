package com.sprint4.productdetails.repository;

import com.sprint4.productdetails.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product,Integer>{
    public Product findProductByProductId(int productId);
}
