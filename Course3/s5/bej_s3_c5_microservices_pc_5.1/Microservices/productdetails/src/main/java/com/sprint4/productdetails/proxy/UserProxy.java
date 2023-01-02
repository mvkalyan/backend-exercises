package com.sprint4.productdetails.proxy;

import com.sprint4.productdetails.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authentication-service",url = "localhost:8084")
public interface UserProxy {
    @PostMapping("/api/jwt/register")
    public ResponseEntity<?> sendUserAuthDetails(@RequestBody UserDTO userDTO);
}
