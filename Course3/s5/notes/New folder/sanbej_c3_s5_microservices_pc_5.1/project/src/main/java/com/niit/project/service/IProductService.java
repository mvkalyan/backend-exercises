package com.niit.project.service;

import com.niit.project.exception.ProductAlreadyExistsException;
import com.niit.project.exception.ProductNotFoundException;
import com.niit.project.exception.UserAlreadyExistsException;
import com.niit.project.exception.UserNotFoundException;
import com.niit.project.model.Product;
import com.niit.project.model.User;

import java.util.List;

public interface IProductService
{
    User registerUser(User user) throws UserAlreadyExistsException;
    User saveUserProductToList(Product product, String userName) throws UserNotFoundException;
    User deleteUserProductFromList(String userName, String productId) throws UserNotFoundException, ProductNotFoundException;
    List<Product> getAllUserProduct(String userName) throws UserNotFoundException;
}
