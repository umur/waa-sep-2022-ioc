package com.example.restfuldemo.dto;

import com.example.restfuldemo.entity.Course;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String major;
    private double gpa;
    private List<Course> coursesTaken=new ArrayList<>();

//    public void addCourse(Course c){
//        coursesTaken.add(c);
//    }
}
