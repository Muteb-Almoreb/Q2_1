package com.example.eventsystem_lap5.API;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResbonse {

    private String message;
    private String status;
    private Object data;

    public ApiResbonse(String message, String status) {
        this.message = message;
        this.status = status;

    }
}
