package com.ultrates.lab1IoC.controller;

import com.ultrates.lab1IoC.annotations.MyAutowired;
import com.ultrates.lab1IoC.annotations.MyBean;
import com.ultrates.lab1IoC.service.EmployeeService;

@MyBean
public class EmployeeController {

    @MyAutowired
    private EmployeeService employeeService;

    public String getEmployeeName(String id){
        return employeeService.getEmployeeName(id);
    }
}
