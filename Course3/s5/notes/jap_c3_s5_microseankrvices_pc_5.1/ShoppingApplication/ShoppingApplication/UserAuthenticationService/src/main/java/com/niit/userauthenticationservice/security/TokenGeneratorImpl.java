package com.niit.userauthenticationservice.security;


import com.niit.userauthenticationservice.domain.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenGeneratorImpl implements TokenGenerator {

    //generating token using map collection,return key-value pair
    @Override
    public Map<String, String> tokenGenerator(Customer customer) {

        Map<String,String> map = new HashMap<>();
        String jwtToken = Jwts.builder().setIssuer("myApp") //identifies subject of JWT
                .setSubject(customer.getCustomerId())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,"mysecret")
                .compact();

        //put will display content on screen
        map.put("Token",jwtToken);
        map.put("Message","LoggedIn successfully");
        return map;
    }
}
