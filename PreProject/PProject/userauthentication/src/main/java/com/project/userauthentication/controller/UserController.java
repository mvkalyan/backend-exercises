package com.project.userauthentication.controller;

import com.project.userauthentication.model.User;
import com.project.userauthentication.services.SecurityTokenGeneratorI;
import com.project.userauthentication.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin("*")
@RequestMapping("/userauth-app/v1")
public class UserController {
    @Autowired
    private UserServiceI userServiceI;

    @Autowired
    private SecurityTokenGeneratorI securityTokenGeneratorI;

//    http://localhost:1912/userauth-app/v1/
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        System.out.println(user);
        return new ResponseEntity<>(userServiceI.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user){
        User result=userServiceI.loginCheck(user.getUserId(),user.getUserPassword());
        if(result!=null){
            Map<String,String> key=securityTokenGeneratorI.generateToken(user);
            return new ResponseEntity<>(key,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Authentication failed",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-userid/{userEmail}")
    public ResponseEntity<?> getUserId(@PathVariable String userEmail){
        return new ResponseEntity<>(userServiceI.getUserIdByUserEmail(userEmail),HttpStatus.OK);
    }

    @GetMapping("/get-emailid/{userId}")
    public ResponseEntity<?> getUserEmail(@PathVariable int userId){
        return new ResponseEntity<>(userServiceI.getUserEmailByUserId(userId),HttpStatus.OK);
    }
}
