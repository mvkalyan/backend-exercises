package com.project.pizzaapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class User {
    @Id
    private String userEmail;
    private String userName;
    private String userAddress;
    private List<Pizza> userPizzaList;
}