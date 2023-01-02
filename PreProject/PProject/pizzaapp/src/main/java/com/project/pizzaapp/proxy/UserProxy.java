package com.project.pizzaapp.proxy;

import com.project.pizzaapp.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-authentication-service",url = "localhost:1912")
public interface UserProxy {
    @PostMapping("/userauth-app/v1/register")
    public ResponseEntity<?> sendUserAuthDetails(@RequestBody UserDTO userDTO);
}
