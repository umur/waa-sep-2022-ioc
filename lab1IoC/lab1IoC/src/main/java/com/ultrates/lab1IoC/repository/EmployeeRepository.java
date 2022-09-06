package com.ultrates.lab1IoC.repository;

import com.ultrates.lab1IoC.annotations.MyBean;

@MyBean
public class EmployeeRepository {
    private String empId="614139";
    private String employeeName="Haile Ghirmay Tesfay";

    public String getEmployeeName(String id){
        if(id.equals(empId))
            return  "The Name of the Employee with the ID#" +id+ "=" +employeeName;
       else
           return    "no employee Found with the ID" +id;
    }
}

