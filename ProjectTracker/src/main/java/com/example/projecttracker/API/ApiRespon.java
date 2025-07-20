package com.example.projecttracker.API;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class ApiRespon {
    private String message;
    private String status;
    private Object data;

    public ApiRespon(String message, String status) {
        this.message = message;
        this.status = status;
    }

}
