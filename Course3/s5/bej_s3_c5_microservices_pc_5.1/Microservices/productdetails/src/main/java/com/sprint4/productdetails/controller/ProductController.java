package com.sprint4.productdetails.controller;

import com.sprint4.productdetails.exceptions.ProductAlreadyExistException;
import com.sprint4.productdetails.exceptions.ProductNotFoundException;
import com.sprint4.productdetails.model.Common;
import com.sprint4.productdetails.model.Product;
import com.sprint4.productdetails.model.UserProduct;
import com.sprint4.productdetails.services.UserServicesI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mart")
public class ProductController {

    @Autowired
    UserServicesI userServicesI;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Common common){
        return new ResponseEntity<>(userServicesI.registerUser(common),HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(userServicesI.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> saveProduct(@RequestBody UserProduct userProduct) throws ProductAlreadyExistException {
        return new ResponseEntity<>(userServicesI.saveUser(userProduct),HttpStatus.CREATED);
    }

    @PutMapping("/product/{productId}")
    public ResponseEntity<?> updateProduct(@RequestBody UserProduct userProduct,@PathVariable String email) throws ProductNotFoundException {
        return new ResponseEntity<>(userServicesI.updateUser(userProduct,email),HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String email) throws ProductNotFoundException {
        return new ResponseEntity<>(userServicesI.deleteUser(email),HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable String email){
        return new ResponseEntity<>(userServicesI.getUserByUserEmail(email),HttpStatus.OK);
    }
}
