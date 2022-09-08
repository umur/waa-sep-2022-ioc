package com.ultrates.lab1IoC.controller;

import com.ultrates.lab1IoC.annotations.MyAutowired;
import com.ultrates.lab1IoC.annotations.MyBean;
import com.ultrates.lab1IoC.service.StudentService;

@MyBean
public class StudenControler {

    @MyAutowired
    private StudentService studentService;

    public String getStudentName(String id){
        return studentService.getStudentName(id);
    }
}
