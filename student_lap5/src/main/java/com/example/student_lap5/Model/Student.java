package com.example.student_lap5.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private String id;
    private String name;
    private int age;
        private int degree;
    private double gpa;
    private String grade;


}
