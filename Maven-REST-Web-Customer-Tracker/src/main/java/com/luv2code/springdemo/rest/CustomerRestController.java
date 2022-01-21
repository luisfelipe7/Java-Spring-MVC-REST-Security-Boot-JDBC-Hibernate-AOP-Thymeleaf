/**
 * 
 */
package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

/**
 * @author Felipe Castro
 *
 */

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// Autowire the CustomerService in charge of taking the data from the database
	@Autowired
	private CustomerService customerService;

	// Add Mapping for Get / Customers - Jackson will be in charge of converting the
	// data from the database to JSON Format
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	// Add Mapping to Get / Customer by ID - Jackson will be in charge of inserting
	// the data using the set methods
	@GetMapping("/customers/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		// Just index into the list

		// Throw exception if the customer brought by the database is null
		Customer foundCustomer = customerService.getCustomer(customerId);
		if (foundCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found: " + customerId);
		} else {
			return foundCustomer;
		}
	}

	// Add Mapping to Post / Add Customer - Jackson will be in charge of inserting
	// the data using the set methods
	@PostMapping("/customers")
	public String addCustomer(@RequestBody Customer theCustomerToAdd) {
		theCustomerToAdd.setId(0); // In order to identify the object as not part of the database
		if (theCustomerToAdd.getFirstName() == null) { // Checking if the object at least is having a first name
			throw new CustomerNotFoundException("Error at the moment of saving the customer, missing/wrong data");
		}

		customerService.saveCustomer(theCustomerToAdd); // Saving the customer

		if (theCustomerToAdd.getId() == 0) {
			throw new CustomerNotFoundException("Error at the moment of saving the customer, missing/wrong data");
		} else {
			return "Customer Added " + theCustomerToAdd.toString();
		}
	}

	// Add Mapping to Put / Update Customer - Jackson will be in charge of inserting
	// the data using the set methods
	@PutMapping("/customers")
	public String updateCustomer(@RequestBody Customer theCustomerToUpdate) {
		// Checking if the id of the customer to update is empty
		if (theCustomerToUpdate.getId() == 0) {
			throw new CustomerNotFoundException(
					"Error at the moment of updating the customer, the id of the customer to update can't be empty");
		} else {
			customerService.saveCustomer(theCustomerToUpdate);
			return "Customer Updated " + theCustomerToUpdate.toString();
		}
	}

	// Add Mapping to Delete / Customer - Jackson will be in charge of inserting
	// the data using the set methods
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		// Checking if the id is not empty
		if (customerId == 0) {
			throw new CustomerNotFoundException(
					"Error at the moment of deleting the customer, the id of the customer to update can't be empty");
		} else {
			// Checking if the customer exists before deleting
			Customer tempCustomer = customerService.getCustomer(customerId);

			if (tempCustomer == null) {
				throw new CustomerNotFoundException(
						"Error at the moment of deleting the customer, the id entered is not in our database");
			} else {
				customerService.deleteCustomer(customerId);
				return "Customer with id " + customerId + " deleted";
			}
		}

	}

}