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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

/**
 * @author Felipe Castro
 *
 */

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// Injecting the Employee Service
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// Add Mapping for "/list"
	@GetMapping("/list")
	private String getEmployees(Model theModel) {
		// Get Employees from database
		List<Employee> theEmployees = employeeService.findAll();

		// Add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	// Add Mapping for "/showFormAdd"
	@GetMapping("/showFormForAdd")
	private String showFormForAdd(Model theModel) {
		// Creating an empty employee for the model
		Employee employee = new Employee();
		// Adding the employee to the model
		theModel.addAttribute("employee", employee);

		return "employees/form-employee";
	}

	// Add Post Mapping for "/save"
	@PostMapping("/save")
	private String saveEmployee(RedirectAttributes redirectAttributes,
			@ModelAttribute("employee") Employee theEmployee) {

		int tempId = theEmployee.getId();

		// Save employee
		employeeService.add(theEmployee);

		// Checking if we are saving or updating
		if (tempId == 0) {
			// Saving a parameter to indicating success of adding the customer
			redirectAttributes.addFlashAttribute("success", "add");
		} else {
			// Saving a parameter to indicating success of editing the customer
			redirectAttributes.addFlashAttribute("success", "edit");
		}

		// Use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}

	// Add Mapping for "/showFormForUpdate"
	@GetMapping("/showFormForUpdate")
	private String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		// Get the Employee from the database
		Employee temEmployee = employeeService.findById(theId);

		// Set the Employee on the Model
		theModel.addAttribute("employee", temEmployee);
		theModel.addAttribute("type", "edit");

		// Sending to the form to update
		return "employees/form-employee";
	}

	// Add Mapping for "/deleteEmployee"
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(RedirectAttributes redirectAttributes, @RequestParam("employeeId") int theId,
			Model theModel) {
		// Delete the customer with primary key
		Employee tempEmployee = new Employee();
		tempEmployee.setId(theId);
		employeeService.delete(tempEmployee);

		// Update the message
		redirectAttributes.addFlashAttribute("success", "delete");

		// Then redirect
		return "redirect:/employees/list";
	}

}
