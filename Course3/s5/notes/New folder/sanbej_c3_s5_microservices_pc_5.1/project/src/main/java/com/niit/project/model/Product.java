package com.niit.project.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product
{
    @Id
    private String productId;
    private String productName;
    private ProductDetails productDetails;
}
