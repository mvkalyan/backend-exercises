package com.niit.usermovieservice.service;

import com.niit.usermovieservice.domain.Product;
import com.niit.usermovieservice.domain.Customer;
import com.niit.usermovieservice.exception.CustomerAlreadyRegistered;
import com.niit.usermovieservice.exception.CustomerUnauthorized;
import com.niit.usermovieservice.exception.ProductNotFound;
import com.niit.usermovieservice.repository.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class UserProductServiceImpl implements UserProductService {

    private UserProductRepository userMovieRepository;

    @Autowired
    public UserProductServiceImpl(UserProductRepository userMovieRepository) {
        this.userMovieRepository = userMovieRepository;
    }

    @Override
    public Customer registerNewCustomer(Customer customer) throws CustomerAlreadyRegistered {

        //checking customer is already registered or not
        if(userMovieRepository.findById(customer.getCustomerId()).isPresent())
        {
            throw new CustomerAlreadyRegistered();
        }
        //if no then
        return userMovieRepository.save(customer);
    }

    @Override
    public Customer saveCustomerProduct(Product product, String customerId) throws CustomerUnauthorized {

        //checking customer by id ,authentication check
        if(userMovieRepository.findById(customerId).isEmpty())
        {
            throw new CustomerUnauthorized();
        }

        // user is authorized and getting customer object from customer id
        Customer customer = userMovieRepository.findById(customerId).get();

        //null describes 0 product
        if(customer == null)
        {
            customer.setProductList(Arrays.asList(product));
        }
        else {

            //create a list of product and adding product object
            List<Product> productList = customer.getProductList();
            productList.add(product);
            customer.setProductList(productList);
        }
        return userMovieRepository.save(customer);
    }

    @Override
    public Customer deleteProductOfACustomer(String customerId, String productId) throws CustomerUnauthorized, ProductNotFound {

        // created a variable of type boolean
        boolean productIdExist = false;

        //checking authentication
        if(userMovieRepository.findById(customerId).isEmpty())
        {
            throw new CustomerUnauthorized();
        }

        //if authenticated, getting customer object using customer id
        Customer customer = userMovieRepository.findById(customerId).get();

        //creating list of product to get product list to verify product id
        List<Product> productList = customer.getProductList();

        //java 8 collection, return type boolean
        productIdExist = productList.removeIf(i->i.getProductId().equals(productId));

        if(!productIdExist)
        {
            throw new ProductNotFound();
        }
        customer.setProductList(productList);
        return userMovieRepository.save(customer);
    }

    @Override
    public List<Product> getAllProductOfACustomer(String customerId) throws CustomerUnauthorized {
        if(userMovieRepository.findById(customerId).isEmpty())
        {
            throw new CustomerUnauthorized();
        }
        return userMovieRepository.findById(customerId).get().getProductList();
    }

}
