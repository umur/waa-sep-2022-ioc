package com.ultrates.lab1IoC.repository;

import com.ultrates.lab1IoC.annotations.MyBean;

@MyBean
public class StudentRepository {
    private String empId="12345";
    private String studentName="Michael  Kinfe";

    public String getStudentName(String id){
            return  studentName;

    }
}

