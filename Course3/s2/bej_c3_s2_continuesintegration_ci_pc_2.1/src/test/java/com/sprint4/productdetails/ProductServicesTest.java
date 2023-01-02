package com.sprint4.productdetails;

import com.sprint4.productdetails.exceptions.ProductAlreadyExistException;
import com.sprint4.productdetails.exceptions.ProductNotFoundException;
import com.sprint4.productdetails.model.Product;
import com.sprint4.productdetails.model.ProductDescription;
import com.sprint4.productdetails.repository.ProductRepository;
import com.sprint4.productdetails.services.ProductServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServicesTest {

    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductServices productServices;

    private Product product;
    private ProductDescription productDescription;

    @BeforeEach
    public void init(){
        productDescription=new ProductDescription(1000000,"Epic");
        product=new Product(25,"Kalyan",productDescription);
    }

    @AfterEach
    public void clear(){
        product=null;
        productDescription=null;
    }

    @Test
    public void givenProductToSaveAndReturnCustomer() throws ProductAlreadyExistException {
        when(productRepository.findById(product.getProductId())).thenReturn(Optional.ofNullable(null));
        when(productRepository.insert(product)).thenReturn(product);
        assertEquals(product,productServices.saveProduct(product));

        verify(productRepository,times(1)).findById(product.getProductId());
        verify(productRepository,times(1)).insert(product);
    }

    @Test
    public void deleteGivenCustomer() throws ProductNotFoundException {
        when(productRepository.findById(product.getProductId())).thenReturn(Optional.ofNullable(product));
        boolean flag=productServices.deleteProduct(product.getProductId());
        assertEquals(true,flag);
    }

//    @Test
//    public void updateAndReturnAGivenProduct() throws ProductAlreadyExistException {
//        when(productRepository.findById(product.getProductId())).thenReturn(Optional.ofNullable(null));
//        assertEquals(product,productServices.saveProduct(product));
//
//        verify(productRepository,times(1)).findById(product.getProductId());
//        verify(productRepository,times(1)).save(product);
//    }
}
