package com.sprint8.jwt.service;


import com.sprint8.jwt.domain.User;

import java.util.Map;

public interface SecurityTokenGeneratorI {

    public Map<String,String> generateToken(User user);
}
