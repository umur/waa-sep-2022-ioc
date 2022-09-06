package com.ultrates.lab1IoC;

import com.ultrates.lab1IoC.annotations.MyComponentScan;
import com.ultrates.lab1IoC.controller.EmployeeController;
import com.ultrates.lab1IoC.injection.MyInjector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
@MyComponentScan("com.ultrates.lab1IoC")
public class Lab1IoCApplication {

	public static void main(String[] args) {
		MyInjector.initialize(Lab1IoCApplication.class);
		EmployeeController employeeController=(EmployeeController)MyInjector.getBean(EmployeeController.class);

		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
		System.out.print("Enter your Employee_Id");
		String employeeID= sc.next();

		System.out.println(employeeController.getEmployeeName(employeeID));
		SpringApplication.run(Lab1IoCApplication.class, args);
	}

}
