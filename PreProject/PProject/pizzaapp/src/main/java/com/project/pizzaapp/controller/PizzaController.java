package com.project.pizzaapp.controller;

import com.project.pizzaapp.model.Pizza;
import com.project.pizzaapp.services.PizzaService;
import com.project.pizzaapp.services.PizzaServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("*")
@RequestMapping("/pizza-app")
public class PizzaController {
    @Autowired
    private PizzaServiceI pizzaServiceI;

//    http://localhost:1913/pizza-app/add-pizza
    @PostMapping("/add-pizza")
    public ResponseEntity<?> addPizza(@RequestBody Pizza pizza){
        return new ResponseEntity<>(pizzaServiceI.addPizza(pizza), HttpStatus.CREATED);
    }

    @GetMapping("/delete-pizza/{pizzaId}")
    public ResponseEntity<?> deletePizza(@PathVariable int pizzaId){
        return new ResponseEntity<>(pizzaServiceI.deletePizza(pizzaId),HttpStatus.OK);
    }

    @GetMapping("/pizzas")
    public ResponseEntity<?> getAllPizzas(){
        return new ResponseEntity<>(pizzaServiceI.getAllPizza(),HttpStatus.OK);
    }

}
