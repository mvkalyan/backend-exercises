package com.niit.course13Sprint4.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Address {
    private int pin;
    private String street;
    private String city;
}
