package com.niit.userauthenticationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //mapping to database table, specifies name
@NoArgsConstructor //no argument constructor
@AllArgsConstructor //non parameterized constructor
@Data //getter-setter-toString

public class Customer {
    @Id
    private String customerId;
    private String password;
}
