package com.niit.course13Sprint4;

import com.niit.course13Sprint4.exception.CustomerAlreadyExistingException;
import com.niit.course13Sprint4.exception.CustomerNotFoundException;
import com.niit.course13Sprint4.model.Address;
import com.niit.course13Sprint4.model.Customer;
import com.niit.course13Sprint4.respoitory.CustomerRepository;
import com.niit.course13Sprint4.service.CustomerServiceImpl;
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
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerServiceImpl customerService;

    private Customer customer;
    private Address address;

    @BeforeEach
    public void setUp(){
        address=new Address(440111,"JM Road","Mumbai");
        customer=new Customer(200,"Ankit",address);
    }

    @AfterEach
    public void clear(){
        address=null;
        customer=null;

    }

    @Test
    public void givenCustomerToSaveReturnCutomer() throws CustomerAlreadyExistingException {

        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(null));
        when(customerRepository.insert(customer)).thenReturn(customer);
        assertEquals(customer,customerService.saveCustomer(customer));

        //how many times repo method are called by service layer

        verify(customerRepository,times(1)).findById(customer.getCustomerId());
        verify(customerRepository,times(1)).insert(customer);
    }

    @Test
    public void deleteGivenCustomer() throws CustomerNotFoundException {
        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(customer));
        boolean flag=customerService.deleteCustomer(customer.getCustomerId());
        assertEquals(true,flag);
    }


}
