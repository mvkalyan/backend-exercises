package com.niit.project.controller;

import com.niit.project.exception.ProductNotFoundException;
import com.niit.project.exception.UserAlreadyExistsException;
import com.niit.project.exception.UserNotFoundException;
import com.niit.project.model.Product;
import com.niit.project.model.User;
import com.niit.project.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController
{
    @Autowired
    IProductService iProductService;

    private ResponseEntity<?> responseEntity;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException
    {
        try
        {
            responseEntity = new ResponseEntity<>(iProductService.registerUser(user), HttpStatus.CREATED);
        }
        catch (UserAlreadyExistsException e)
        {
            throw new UserAlreadyExistsException();
        }
        return responseEntity;
    }

    @PostMapping("/user/{userName}/product")
    public ResponseEntity<?> saveUserProductToList(@RequestBody Product product, @PathVariable String userName) throws UserNotFoundException
    {
        try
        {
            responseEntity = new ResponseEntity<>(iProductService.saveUserProductToList(product,userName), HttpStatus.CREATED);
        }
        catch (UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }

    @GetMapping("/user/{userName}/products")
    public ResponseEntity<?> getAllUserProductsFromList(@PathVariable String userName) throws UserNotFoundException
    {
        try
        {
            responseEntity = new ResponseEntity<>(iProductService.getAllUserProduct(userName), HttpStatus.OK);
        }
        catch (UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }

    @DeleteMapping("/user/{userName}/{productId}")
    public ResponseEntity<?> deleteUserProductFromList(@PathVariable String userName, @PathVariable String productId) throws UserNotFoundException, ProductNotFoundException
    {
        try
        {
            responseEntity = new ResponseEntity<>(iProductService.deleteUserProductFromList(userName,productId), HttpStatus.OK);
        }
        catch (UserNotFoundException | ProductNotFoundException e)
        {
            throw new ProductNotFoundException();
        }
        return responseEntity;
    }
}
