package com.project.pizzaapp.repository;

import com.project.pizzaapp.model.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends MongoRepository<Pizza,Integer> {
}
