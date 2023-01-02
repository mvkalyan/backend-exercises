package com.sprint4.productdetails;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint4.productdetails.controller.ProductController;
import com.sprint4.productdetails.exceptions.ProductAlreadyExistException;
import com.sprint4.productdetails.model.Product;
import com.sprint4.productdetails.model.ProductDescription;
import com.sprint4.productdetails.services.ProductServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    @Mock//dependency
    private ProductServices productServices;
    @InjectMocks //dependent
    private ProductController productController;

    private Product product;
    private ProductDescription productDescription;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        productDescription=new ProductDescription(520000000,"Avenger");
        product=new Product(201,"MVK",productDescription);
        mockMvc= MockMvcBuilders.standaloneSetup(productController).build();
    }

    @AfterEach
    public void clear(){
        product=null;
        productDescription=null;
    }

    @Test
    public void productDataToSaveSuccess() throws Exception {
        when(productServices.saveProduct(product)).thenReturn(product);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/mart/product").
                        contentType(MediaType.APPLICATION_JSON).
                        content(convertToJson(product))).
                        andExpect(status().isCreated()).
                        andDo(print());
    }

    @Test
    public void productDataToSaveFailed() throws Exception {
        when(productServices.saveProduct(product)).thenReturn(product);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/mart/product").
                        contentType(MediaType.APPLICATION_JSON).
                        content(convertToJson(product))).
                        andExpect(status().isCreated()).
                        andDo(print());
    }

//    @Test
//    public void getAllProducts() throws Exception
//    {
//        mockMvc.perform( MockMvcRequestBuilders
//                        .get("/mart/product")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.Product").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.Product[*].productId").isNotEmpty());
//    }

    public static String convertToJson(final Object obj) throws JsonProcessingException {
        String result="";

        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

}