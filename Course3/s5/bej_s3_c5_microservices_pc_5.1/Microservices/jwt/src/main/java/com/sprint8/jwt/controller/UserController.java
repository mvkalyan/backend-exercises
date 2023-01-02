package com.sprint8.jwt.controller;

import com.sprint8.jwt.domain.User;
import com.sprint8.jwt.service.SecurityTokenGeneratorI;
import com.sprint8.jwt.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/api/jwt")
public class UserController {
    @Autowired
    private UserServiceI userServiceI;

    @Autowired
    private SecurityTokenGeneratorI securityTokenGeneratorI;

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
}
