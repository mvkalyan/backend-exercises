package com.project.userauthentication.services;


import com.project.userauthentication.model.User;

import java.util.Map;

public interface SecurityTokenGeneratorI {
    public Map<String,String> generateToken(User user);
}
