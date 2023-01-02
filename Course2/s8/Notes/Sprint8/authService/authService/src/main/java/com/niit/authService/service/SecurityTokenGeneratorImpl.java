package com.niit.authService.service;
import com.niit.authService.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(User user) {
        Map<String,String> result=new HashMap<String, String>();

        Map<String,Object> data=new HashMap<>();
        data.put("userObjcet",user);

        String jwtToken= Jwts.builder().setClaims(data).
                setIssuedAt(new Date()).
                signWith(SignatureAlgorithm.HS512,"mysecuritykey").
                compact();
        result.put("token",jwtToken);

        return result;
    }
}
