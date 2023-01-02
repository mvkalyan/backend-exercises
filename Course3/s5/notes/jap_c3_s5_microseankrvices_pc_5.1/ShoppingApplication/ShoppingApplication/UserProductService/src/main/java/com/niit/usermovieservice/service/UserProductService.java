package com.niit.usermovieservice.service;

import com.niit.usermovieservice.domain.Product;
import com.niit.usermovieservice.domain.Customer;
import com.niit.usermovieservice.exception.CustomerAlreadyRegistered;
import com.niit.usermovieservice.exception.CustomerUnauthorized;
import com.niit.usermovieservice.exception.ProductNotFound;

import java.util.List;

public interface UserProductService {

    //registering new customer
    Customer registerNewCustomer(Customer customer) throws CustomerAlreadyRegistered;

    //saving product of a specific customer by customer id
    Customer saveCustomerProduct(Product product, String customerId) throws CustomerUnauthorized;

    //deleting product of a specific customer by customer id and product id
    Customer deleteProductOfACustomer(String customerId, String productId) throws CustomerUnauthorized , ProductNotFound;

    //getting all products for a specific customer by customer id
    List<Product> getAllProductOfACustomer(String customerId) throws CustomerUnauthorized;

}
