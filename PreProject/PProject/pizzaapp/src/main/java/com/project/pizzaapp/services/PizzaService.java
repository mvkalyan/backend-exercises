package com.project.pizzaapp.services;

import com.project.pizzaapp.model.Pizza;
import com.project.pizzaapp.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService implements PizzaServiceI{
    @Autowired
    private PizzaRepository pizzaRepository;
    @Override
    public Pizza addPizza(Pizza pizza) {
        if(pizzaRepository.existsById(pizza.getPizzaId())){
            return null;
        }
        else{
            return pizzaRepository.insert(pizza);
        }
    }

    @Override
    public Boolean deletePizza(int pizzaId) {
        if(pizzaRepository.existsById(pizzaId)){
            pizzaRepository.deleteById(pizzaId);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }
}
