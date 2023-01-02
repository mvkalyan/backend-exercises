package com.niit.usermovieservice.controller;

import com.niit.usermovieservice.domain.Product;
import com.niit.usermovieservice.domain.Customer;
import com.niit.usermovieservice.exception.ProductNotFound;
import com.niit.usermovieservice.exception.CustomerAlreadyRegistered;
import com.niit.usermovieservice.exception.CustomerUnauthorized;
import com.niit.usermovieservice.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping/product")
public class UserProductController {
private UserProductService userProductService;
private ResponseEntity<?> responseEntity;

@Autowired
    public UserProductController(UserProductService userProductService) {
    this.userProductService = userProductService;
    }

    // getting all the product details for a specific user with customer id
    @GetMapping("/get/{customerId}")
    public ResponseEntity<?> getAllProductsOfACustomer(@PathVariable String customerId) throws CustomerUnauthorized {
        try{
            responseEntity = new ResponseEntity<>(userProductService.getAllProductOfACustomer(customerId), HttpStatus.OK);
        }catch(CustomerUnauthorized e)
        {
            throw new CustomerUnauthorized();
        }
        return responseEntity;
    }

    // registering user into userProductService application
    @PostMapping("/register")
    public ResponseEntity<?> registerNewCustomer(@RequestBody Customer customer) throws CustomerAlreadyRegistered {
    try {
        responseEntity =  new ResponseEntity<>(userProductService.registerNewCustomer(customer), HttpStatus.CREATED);
    }
    catch(CustomerAlreadyRegistered e)
    {
        throw new CustomerAlreadyRegistered();
    }
    return responseEntity;
    }

    // saving user product for specific customer with customer id
    @PostMapping("/add/{customerId}")
    public ResponseEntity<?> saveCustomerProduct(@RequestBody Product product, @PathVariable String customerId) throws CustomerUnauthorized {
    try {
        responseEntity = new ResponseEntity<>(userProductService.saveCustomerProduct(product, customerId), HttpStatus.CREATED);
    }
    catch (CustomerUnauthorized e)
    {
        throw new CustomerUnauthorized();
    }
    return responseEntity;
    }

    // deleting user product for specific customer with customer id and product id
    @DeleteMapping("/remove/{customerId}/{productId}")
    public ResponseEntity<?> deleteProductOfACustomer(@PathVariable String customerId,@PathVariable String productId)
            throws CustomerUnauthorized, ProductNotFound
    {
        try {
            responseEntity = new ResponseEntity<>(userProductService.deleteProductOfACustomer(customerId, productId), HttpStatus.OK);
        } catch (CustomerUnauthorized | ProductNotFound m) {
            throw new ProductNotFound();
        }
        return responseEntity;
    }
}

