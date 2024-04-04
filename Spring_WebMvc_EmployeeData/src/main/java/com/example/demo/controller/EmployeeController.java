package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.binding.Employee;

@Controller
public class EmployeeController {

	@GetMapping("/employee")
	public String getEmployeeDetails(Model model) {
		
		Employee emp=new Employee(101,"Sanjay",23000.00);
		model.addAttribute("employee", emp);
		return "employee";
		
	}
	
	@GetMapping("/employees")
	public String getEmpsData(Model model) {
		
		Employee emp1=new Employee(102,"Kartik",300000.00);
		Employee emp2=new Employee(103,"Ganesh",400000.00);
		Employee emp3=new Employee(104,"Sangam",500000.00);
		
		List<Employee> asList = Arrays.asList(emp1,emp2,emp3);
		
		model.addAttribute("employees", asList);
		
		return "employees";
	}
	
}
