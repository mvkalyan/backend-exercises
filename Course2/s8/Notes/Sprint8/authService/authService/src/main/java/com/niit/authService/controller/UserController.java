package com.niit.authService.controller;

import com.niit.authService.model.User;
import com.niit.authService.service.IUserService;
import com.niit.authService.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/authservice")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        user.setRole("Role_User");
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user){
        User result=userService.loginCheck(user.getUserId(),user.getPassword());
        if(result!=null){
            //login sucess
            Map<String,String> key=securityTokenGenerator.generateToken(user);
            return new ResponseEntity<>(key,HttpStatus.OK);
        }else{
            //login failed
            return new ResponseEntity<>("Authentication failed",HttpStatus.NOT_FOUND);
        }

    }
}
