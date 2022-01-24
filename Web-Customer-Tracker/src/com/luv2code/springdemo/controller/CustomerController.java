/**
 * 
 */
package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

/**
 * @author Felipe Castro
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Need to inject the service layer called Customer Service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// Get customers from the DAO
		List<Customer> theCustomers = customerService.getCustomers();

		// Add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// Create Model Attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		theModel.addAttribute("type", "add");

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(RedirectAttributes redirectAttributes,
			@ModelAttribute("customer") Customer theCustomer) {
		// Checking if we are saving or updating the customer
		int tempId = theCustomer.getId();

		// SAVING/UPDATING the customer using our service
		customerService.saveCustomer(theCustomer);

		if (tempId == 0) {
			// Saving a parameter to indicating success of adding the customer
			redirectAttributes.addFlashAttribute("success", "add");
		} else {
			// Saving a parameter to indicating success of editing the customer
			redirectAttributes.addFlashAttribute("success", "edit");
		}

		// Then redirecting to the table
		return "redirect:/customer/list";
	}

	@PostMapping("/searchByName")
	public String searchByName(@RequestParam("nameToSearch") String nameToSearch, Model theModel) {
		// Performing the search with the name entered
		List<Customer> curstomersWithName = customerService.getCustomersByName(nameToSearch);

		// Updating the model with the result
		theModel.addAttribute("customers", curstomersWithName);

		// Then redirecting to the table
		return "list-customers";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		// Get the customer from the database
		Customer theCustomer = customerService.getCustomer(theId);

		// Set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		theModel.addAttribute("type", "edit");

		// Send over to our form
		return "customer-form";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(RedirectAttributes redirectAttributes, @RequestParam("customerId") int theId,
			Model theModel) {
		// Delete the customer with primary key
		customerService.deleteCustomer(theId);

		// Update the message
		redirectAttributes.addFlashAttribute("success", "delete");

		// Then redirect
		return "redirect:/customer/list";
	}

}
