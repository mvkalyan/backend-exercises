package com.sprint4.productdetails.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document
public class Product {
    @Id
    private int productId;
    private String productName;
    private ProductDescription productDescription;

//    public Product() {
//    }
//
//    public Product(int productId, String productName, ProductDescription productDescription) {
//        this.productId = productId;
//        this.productName = productName;
//        this.productDescription = productDescription;
//    }
//
//    public int getProductId() {
//        return productId;
//    }
//
//    public void setProductId(int productId) {
//        this.productId = productId;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public ProductDescription getProductDescription() {
//        return productDescription;
//    }
//
//    public void setProductDescription(ProductDescription productDescription) {
//        this.productDescription = productDescription;
//    }
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "productId=" + productId +
//                ", productName='" + productName + '\'' +
//                ", productDescription=" + productDescription +
//                '}';
//    }
}
