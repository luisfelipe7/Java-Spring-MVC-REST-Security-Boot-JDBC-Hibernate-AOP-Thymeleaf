/**
 * 
 */
package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

/**
 * @author Felipe Castro
 *
 */

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	// Load Employee Data
	private List<Employee> theEmployees;

	@PostConstruct
	private void loadData() {
		// Create Employees
		Employee emp1 = new Employee(1, "Leslie", "Andrews", "lesli@gmail.com");
		Employee emp2 = new Employee(2, "Kevin", "Lude", "kevin@gmail.com");
		Employee emp3 = new Employee(3, "Ponyo", "Zamore", "ponyo@gmail.com");

		// Initialize the list
		theEmployees = new ArrayList<>();

		// Add to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);

	}

	// Add Mapping for "/list"
	@GetMapping("/list")
	private String getEmployees(Model theModel) {
		// Add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
	
	
}
