package com.niit.userauthenticationservice.security;



import com.niit.userauthenticationservice.domain.Customer;

import java.util.Map;

public interface TokenGenerator {

    //generating key-value pair using map in collections for token and message
    Map<String,String> tokenGenerator(Customer customer);
}
