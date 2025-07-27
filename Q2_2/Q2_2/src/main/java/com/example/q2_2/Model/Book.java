package com.example.q2_2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    //Book Class :
    //      ID , name , number_of_pages , price  , category  , isAvailable
    //all should not be empty
    //category is novel OR academic

    @NotEmpty(message = "Name must not be Empty")
    private String name;

    @NotEmpty(message = "Id must not be Empty")
    private String id;


    @NotNull(message = "Number of pages must not be Empty")
    private int number_of_pages;


    @NotNull(message = "Number of pages must not be Empty")
    private double price;
    @NotEmpty(message = "Number of pages must not be Empty")
    @Pattern(regexp = "^(?i)novel|academic$", message = "novel OR academic")
    private String category;


    private boolean isAvailable;
}
