package com.sprint4.productdetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProduct {
    @Id
    private String userEmail;
    private String userName;
    private String userAddress;
    private List<Product> userProducts;
}
