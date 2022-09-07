package com.ultrates.lab1IoC.service;

import com.ultrates.lab1IoC.annotations.MyAutowired;
import com.ultrates.lab1IoC.annotations.MyBean;
import com.ultrates.lab1IoC.repository.StudentRepository;

@MyBean
public class StudentService {
    @MyAutowired
    private StudentRepository studentRepository;

    public String getStudentName(String id){
        return this.studentRepository.getStudentName(id);
    }

    }
