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
public class User {



    @NotEmpty(message = "Name must not be empty")
    private String name;

    @NotEmpty(message = "Id must be not empty")
    private String id;
    @NotNull(message = "Age must be not empty")
    private int age;

    @NotNull(message = "balance must be not empty")
    private double balance;


    @NotEmpty(message = "Role must be not empty")
    @Pattern(regexp = "^(?i)customer|librarian$")
    private String role;

}
