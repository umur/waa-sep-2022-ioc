package com.ultrates.lab1IoC;

import com.ultrates.lab1IoC.annotations.MyComponentScan;
import com.ultrates.lab1IoC.controller.StudenControler;
import com.ultrates.lab1IoC.injection.MyInjector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
@MyComponentScan("com.ultrates.lab1IoC")
public class Lab1IoCApplication {

	public static void main(String[] args) {
		MyInjector.initialize(Lab1IoCApplication.class);
		StudenControler studentController=(StudenControler)MyInjector.getBean(StudenControler.class);

		String studentID= "12345";

		System.out.println(studentController.getStudentName(studentID));
		SpringApplication.run(Lab1IoCApplication.class, args);
	}

}
