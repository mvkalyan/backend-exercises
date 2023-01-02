package com.stackroute.UserService.controller;


import com.stackroute.UserService.model.User;

import com.stackroute.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //@Controller + @responsebody
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }
//http://8082/api/v1/user
    @PostMapping("/user")     //post
    public ResponseEntity<?> saveUser(@RequestBody User user){
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }
    @GetMapping("/users/{lastName}")
    public ResponseEntity<?> getAllUsersByLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(userService.getUserByLastName(lastName), HttpStatus.FOUND);
    }
    @DeleteMapping("/use{emailr/}")
    public ResponseEntity<?> deleteUser(@PathVariable String email){
        return new ResponseEntity<>(userService.deleteUserByEmail(email), HttpStatus.OK);
    }

    @PutMapping("/user/{email}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String email) {
        return new ResponseEntity<>(userService.updateUser(user,email), HttpStatus.OK);
    }


}
