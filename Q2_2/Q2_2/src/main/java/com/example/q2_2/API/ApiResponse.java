package com.example.q2_2.API;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

@NoArgsConstructor
public class ApiResponse {

    private String message;
}
