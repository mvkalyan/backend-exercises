package com.sprint8.jwt.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/jwt")
public class UserController {
    @Autowired
    private UserServiceI userServiceI;

    @Autowired
    private SecurityTokenGeneratorI securityTokenGeneratorI;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        return new ResponseEntity<>(userServiceI.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @HystrixCommand(fallbackMethod = "fallbackMethod",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
    public ResponseEntity<?> loginCheck(@RequestBody User user) throws InterruptedException {
        User result=userServiceI.loginCheck(user.getUserId(),user.getUserPassword());
        if(result!=null){
            Map<String,String> key=securityTokenGeneratorI.generateToken(user);
            return new ResponseEntity<>(key,HttpStatus.OK);
        }
        else{
            Thread.sleep(10000);
            return new ResponseEntity<>("Authentication failed",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fallbackMethod(@RequestBody User user){
        return new ResponseEntity<>("Login Failed due to server Down :(",HttpStatus.BAD_GATEWAY);
    }
}
