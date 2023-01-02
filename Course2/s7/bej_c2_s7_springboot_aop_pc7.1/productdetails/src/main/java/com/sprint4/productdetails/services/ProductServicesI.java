package com.sprint4.productdetails.services;

import com.sprint4.productdetails.exceptions.ProductAlreadyExistException;
import com.sprint4.productdetails.exceptions.ProductNotFoundException;
import com.sprint4.productdetails.model.Product;

import java.util.List;

public interface ProductServicesI {
    public Product saveProduct(Product product) throws ProductAlreadyExistException;
    public Product updateProduct(Product product,int productId) throws ProductNotFoundException;
    public Product getProductByProductId(int productId);
    public boolean deleteProduct(int productId) throws ProductNotFoundException;
    public List<Product> getAllProducts();
}
