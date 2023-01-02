package com.project.pizzaapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pizza {
    @Id
    private int pizzaId;
    private String pizzaName;
    private String pizzaSize;
    private int pizzaCost;
}
