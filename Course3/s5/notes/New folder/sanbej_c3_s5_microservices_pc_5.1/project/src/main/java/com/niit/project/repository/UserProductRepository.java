package com.niit.project.repository;

import com.niit.project.model.Product;
import com.niit.project.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProductRepository extends MongoRepository<User, String>
{
    User findByUserName(String userName);
}
