package com.example.q2_1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    //Book Class :
    //      ID , name , number_of_pages , price  , category  , isAvailable
    //all should not be empty
    //category is novel OR academic
    @NotEmpty(message = "Id must be not empty")
    private String id;

    @NotEmpty(message = "Name must be not empty")
    private String name ;

    @NotNull(message = "Number of pages must be not empty")
    private int number_of_pages;

    @NotNull(message = "Price must be not empty")
    private double price;

    @NotEmpty(message = "Role must be not empty")
    @Pattern(regexp = "^(?i)novel|academic$" , message = " Novel or Academic")
    private String category;


    private boolean isAvailable;

}
