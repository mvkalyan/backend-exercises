package com.niit.authService.service;

import com.niit.authService.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {

    public Map<String,String> generateToken(User user);
}
