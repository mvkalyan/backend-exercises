package com.niit.course13Sprint4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.course13Sprint4.controller.CustomerController;
import com.niit.course13Sprint4.exception.CustomerAlreadyExistingException;
import com.niit.course13Sprint4.model.Address;
import com.niit.course13Sprint4.model.Customer;
import com.niit.course13Sprint4.service.CustomerServiceImpl;
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
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    @Mock
    private CustomerServiceImpl customerService;
    @InjectMocks
    private CustomerController customerController;
    Customer customer;
    Address address;
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    public void setUp(){
        address=new Address(440111,"JM Road","Mumbai");
        customer=new Customer(200,"Ankit",address);
        mockMvc= MockMvcBuilders.standaloneSetup(customerController).build();
    }
    @AfterEach
    public void clear(){
        address=null;
        customer=null;
    }

    @Test
    public void customerDataToSaveSucess() throws Exception {
        when(customerService.saveCustomer(customer)).thenReturn(customer);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/customerdata/customer").
                        contentType(MediaType.APPLICATION_JSON).
                        content(convertToJson(customer)))
                        .andExpect(status().isCreated()).
                        andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void customerDataToSaveFailed() throws Exception {
        when(customerService.saveCustomer(customer)).thenReturn(customer);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/customerdata/customer").
                                contentType(MediaType.APPLICATION_JSON).
                                content(convertToJson(customer)))
                .andExpect(status().isConflict()).
                andDo(MockMvcResultHandlers.print());
    }

    public static  String convertToJson(final Object obj) throws JsonProcessingException {
        String result="";

        ObjectMapper mapper=new ObjectMapper();
        result=mapper.writeValueAsString(obj);
        return result;
    }



}
