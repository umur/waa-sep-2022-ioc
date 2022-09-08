package com.example.restfuldemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String major;
    private double gpa;
    private List<Course> coursesTaken=new ArrayList<>();

    public Student(int id, String firstName, String lastName, String emailId, String major, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.major = major;
        this.gpa = gpa;

    }

    public void addCourse(Course c){
        coursesTaken.add(c);
    }



}
