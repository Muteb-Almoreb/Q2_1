package com.example.q2_1.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //User Class :
    //    ID , name , age ,  balance , role
    //    1. all should not be empty
    //    2. balance should be a valid number
    //    3. The role is   customer OR librarian

    @NotEmpty(message = "Id must be empty")
    private String Id;

    @NotEmpty(message = "Name must be empty")
    private String name;

    @NotNull(message = "Age must be empty")
    private int age;


    @NotNull(message = "Age must be empty")
    private double balance;

    @NotEmpty(message = "Role must be not empty")
    @Pattern(regexp = "^(?i)customer|librarian$", message = " customer Or Librarian")
    private String role;
}
