package com.ultrates.lab1IoC.service;

import com.ultrates.lab1IoC.annotations.MyAutowired;
import com.ultrates.lab1IoC.annotations.MyBean;
import com.ultrates.lab1IoC.repository.EmployeeRepository;

@MyBean
public class EmployeeService {
    @MyAutowired
    private EmployeeRepository employeeRepository;

    public String getEmployeeName(String id){
        return this.employeeRepository.getEmployeeName(id);
    }

    }
