package com.niit.userauthenticationservice.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.niit.userauthenticationservice.domain.User;
import com.niit.userauthenticationservice.exception.InvalidCredentialsException;
import com.niit.userauthenticationservice.exception.UserAlreadyExistsException;
import com.niit.userauthenticationservice.security.SecurityTokenGenerator;
import com.niit.userauthenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }
    @PostMapping("/login")
    @HystrixCommand(fallbackMethod = "fallbackLogin",commandKey = "loginKey",groupKey = "login")
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws InvalidCredentialsException, InterruptedException {
        User retrievedUser = userService.findByEmailAndPassword(user.getEmail(),user.getPassword());


        Thread.sleep(6000);
        if(retrievedUser==null)
        {
            throw new InvalidCredentialsException();
        }
        Map<String,String> map = securityTokenGenerator.generateToken(user);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }


    public ResponseEntity<?> fallbackLogin(@RequestBody User user)
            throws InvalidCredentialsException{
        String msg = "login failed";
        return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
    }


}
