package com.niit.usermovieservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@NoArgsConstructor //no argument constructor
@AllArgsConstructor //non parameterized constructor
@Data //getter-setter-toString

public class Product {
    @Id
    private String productId;
    private String productName;
    private String productDescription;
    private int productStock;
}