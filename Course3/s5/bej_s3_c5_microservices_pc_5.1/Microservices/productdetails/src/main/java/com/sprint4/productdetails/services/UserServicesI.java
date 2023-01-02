package com.sprint4.productdetails.services;

import com.sprint4.productdetails.exceptions.ProductAlreadyExistException;
import com.sprint4.productdetails.exceptions.ProductNotFoundException;
import com.sprint4.productdetails.model.Common;
import com.sprint4.productdetails.model.Product;
import com.sprint4.productdetails.model.UserProduct;

import java.util.List;

public interface UserServicesI {
    public UserProduct saveUser(UserProduct userProduct) throws ProductAlreadyExistException;
    public UserProduct updateUser(UserProduct userProduct,String email) throws ProductNotFoundException;
    public UserProduct getUserByUserEmail(String email);
    public boolean deleteUser(String email) throws ProductNotFoundException;
    public List<UserProduct> getAllUsers();

    public UserProduct registerUser(Common common);
}
