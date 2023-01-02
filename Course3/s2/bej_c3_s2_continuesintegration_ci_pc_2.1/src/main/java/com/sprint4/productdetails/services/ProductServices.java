package com.sprint4.productdetails.services;

import com.sprint4.productdetails.exceptions.ProductAlreadyExistException;
import com.sprint4.productdetails.exceptions.ProductNotFoundException;
import com.sprint4.productdetails.model.Product;
import com.sprint4.productdetails.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices implements ProductServicesI{
    private ProductRepository productRepository;
    @Autowired
    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) throws ProductAlreadyExistException {
        if(productRepository.findById(product.getProductId()).isEmpty()){
            productRepository.insert(product);
            return product;
        }
        else{
            throw new ProductAlreadyExistException();
        }
    }

    @Override
    public Product updateProduct(Product product,int productId) throws ProductNotFoundException {
        if(productRepository.findById(productId).isEmpty()){
            throw new ProductNotFoundException();
        }
        else{
            productRepository.save(product);
            return product;
        }
    }


    public Product getProductByProductId(int productId) {
        return productRepository.findProductByProductId(productId);
    }

    @Override
    public boolean deleteProduct(int productId) throws ProductNotFoundException {
        if(productRepository.findById(productId).isEmpty()){
            throw new ProductNotFoundException();
        }
        else{
            productRepository.deleteById(productId);
            return true;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
