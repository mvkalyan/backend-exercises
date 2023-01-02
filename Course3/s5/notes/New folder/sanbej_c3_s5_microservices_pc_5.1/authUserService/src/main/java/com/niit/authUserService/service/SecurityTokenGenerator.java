package com.niit.authUserService.service;

import com.niit.authUserService.model.User;

import java.util.Map;

public interface SecurityTokenGenerator
{
    public Map<String,String> generateToken(User user);
}
