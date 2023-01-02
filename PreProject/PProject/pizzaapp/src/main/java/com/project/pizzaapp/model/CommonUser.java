package com.project.pizzaapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonUser {
    private String email;
    private String password;
    private String name;
    private String address;
}
