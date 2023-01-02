package com.niit.usermovieservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@NoArgsConstructor //no argument constructor
@AllArgsConstructor //non parameterized constructor
@Data //getter-setter-toString

public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private String shippingAddress;
    private String email;
    private String password;
    private List<Product> productList;

}
