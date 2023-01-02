package com.project.pizzaapp.controller;

import com.project.pizzaapp.exceptions.UserNotFoundException;
import com.project.pizzaapp.model.CommonUser;
import com.project.pizzaapp.model.Pizza;
import com.project.pizzaapp.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/pizza-user")
public class UserController {
    @Autowired
    private UserServiceI userServiceI;

//  http://localhost:1913/pizza-user/register
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CommonUser commonUser){
        return new ResponseEntity<>(userServiceI.registerUser(commonUser), HttpStatus.CREATED);
    }

    @PostMapping("/add-pizza/{emailId}")
    public ResponseEntity<?> addPizzaToUserAccount(@RequestBody Pizza pizza, @PathVariable String emailId) throws UserNotFoundException {
        return new ResponseEntity<>(userServiceI.addPizzaToUser(emailId,pizza),HttpStatus.CREATED);
    }

    @DeleteMapping("/clear-cart/{emailId}")
    public ResponseEntity<?> clearUserCart(@PathVariable String emailId){
        return new ResponseEntity<>(userServiceI.clearUserPizza(emailId),HttpStatus.OK);
    }

    @GetMapping("/get-user-pizza/{emailId}")
    public ResponseEntity<?> getUserPizzas(@PathVariable String emailId){
        return new ResponseEntity<>(userServiceI.getUserByUserEmail(emailId),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-item/{emailId}/{pizzaId}")
    public ResponseEntity<?> deletePizzaFromUser(@PathVariable int pizzaId,@PathVariable String emailId) throws UserNotFoundException {
        return new ResponseEntity<>(userServiceI.deletePizzaFromUser(emailId, pizzaId),HttpStatus.OK);
    }
}