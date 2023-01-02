package com.example.myfirstspringboot.services;

import org.springframework.stereotype.Service;

@Service
public class Greet {
    public String greetingMessage(){
        return "Good day to you :)";
    }
}
