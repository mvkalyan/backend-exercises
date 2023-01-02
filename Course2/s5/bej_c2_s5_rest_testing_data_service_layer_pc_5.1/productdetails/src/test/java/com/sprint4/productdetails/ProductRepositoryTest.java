package com.sprint4.productdetails;

import com.sprint4.productdetails.model.Product;
import com.sprint4.productdetails.model.ProductDescription;
import com.sprint4.productdetails.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    private Product product;
    private ProductDescription productDescription;

    @BeforeEach
    public void init(){
        productDescription=new ProductDescription(500000,"Epic");
        product=new Product(25,"Kalyan",productDescription);
    }

    @AfterEach
    public void clear(){
        productRepository.deleteById(product.getProductId());
        product=null;
        productDescription=null;
    }

    @Test
    public void givenProductDetailsToReturnProduct(){
        productRepository.insert(product);
        //Product p=productRepository.findById(product.getProductId()).get();
        //assertTrue(p.equals(product));
        //assertEquals(p,product);
        assertEquals(product,productRepository.findProductByProductId(product.getProductId()));

    }

    @Test
    public void getAllProducts(){
        productRepository.insert(product);
        List<Product> list=productRepository.findAll();
        assertEquals(19,list.size());
    }

    @Test
    public void givenProductToDelete(){
        productRepository.insert(product);
        productRepository.deleteById(product.getProductId());
        assertFalse(productRepository.findById(product.getProductId()).isPresent());
        //assertEquals(Optional.empty(),productRepository.findById(product.getProductId()));
    }

    @Test
    public void givenProductToUpdate(){
        assertEquals(product,productRepository.save(product));
    }

    @Test
    public void givenIdToGetProduct(){
        assertEquals(1,productRepository.findById(1).get().getProductId());
    }


}
