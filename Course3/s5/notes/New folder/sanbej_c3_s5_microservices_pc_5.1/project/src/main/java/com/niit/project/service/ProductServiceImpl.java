package com.niit.project.service;

import com.niit.project.exception.ProductNotFoundException;
import com.niit.project.exception.UserAlreadyExistsException;
import com.niit.project.exception.UserNotFoundException;
import com.niit.project.model.Product;
import com.niit.project.model.User;
import com.niit.project.repository.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements IProductService
{
    @Autowired
    private UserProductRepository userProductRepository;

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        if (userProductRepository.findById(user.getUserName()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        return userProductRepository.save(user);
    }

    @Override
    public User saveUserProductToList(Product product, String userName) throws UserNotFoundException
    {
        if (userProductRepository.findById(userName).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = userProductRepository.findByUserName(userName);
        if (user.getProductList() == null)
        {
            user.setProductList(Arrays.asList(product));
        }
        else
        {
            List<Product> products = user.getProductList();
            products.add(product);
            user.setProductList(products);
        }
        return userProductRepository.save(user);
    }

    @Override
    public User deleteUserProductFromList(String userName, String productId) throws UserNotFoundException, ProductNotFoundException
    {
        boolean productIdPresent = false;
        if (userProductRepository.findById(userName).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = userProductRepository.findById(userName).get();
        List<Product> products = user.getProductList();
        productIdPresent = products.removeIf(d->d.getProductId().equals(productId));
        if (!productIdPresent)
        {
            throw new ProductNotFoundException();
        }
        user.setProductList(products);
        return userProductRepository.save(user);
    }

    @Override
    public List<Product> getAllUserProduct(String userName) throws UserNotFoundException
    {
        if (userProductRepository.findById(userName).isEmpty())
        {
            throw new UserNotFoundException();
        }
        return userProductRepository.findById(userName).get().getProductList();
    }
}
