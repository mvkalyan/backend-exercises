package com.sprint4.productdetails.controller;

import com.sprint4.productdetails.exceptions.ProductAlreadyExistException;
import com.sprint4.productdetails.exceptions.ProductNotFoundException;
import com.sprint4.productdetails.model.Product;
import com.sprint4.productdetails.services.ProductServicesI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mart")
public class ProductController {

    @Autowired
    ProductServicesI productServicesI;

    @GetMapping("/product")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(productServicesI.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) throws ProductAlreadyExistException {
        return new ResponseEntity<>(productServicesI.saveProduct(product),HttpStatus.CREATED);
    }

    @PutMapping("/product/{productId}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product,@PathVariable int productId) throws ProductNotFoundException {
        return new ResponseEntity<>(productServicesI.updateProduct(product,productId),HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productId) throws ProductNotFoundException {
        return new ResponseEntity<>(productServicesI.deleteProduct(productId),HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable int productId){
        return new ResponseEntity<>(productServicesI.getProductByProductId(productId),HttpStatus.OK);
    }
}
