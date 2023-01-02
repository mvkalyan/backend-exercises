package com.sprint4.productdetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Common {
    private String email;
    private String password;
    private String name;
    private String address;
}

