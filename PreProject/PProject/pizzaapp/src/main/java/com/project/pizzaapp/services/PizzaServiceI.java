package com.project.pizzaapp.services;

import com.project.pizzaapp.model.Pizza;

import java.util.List;

public interface PizzaServiceI {
    Pizza addPizza(Pizza pizza);
    Boolean deletePizza(int pizzaId);
    List<Pizza> getAllPizza();
}
