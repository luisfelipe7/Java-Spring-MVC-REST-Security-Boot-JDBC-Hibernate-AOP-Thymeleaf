/**
 * 
 */
package com.luv2code.springboot.springbootrestcrud.rest;

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

import com.luv2code.springboot.springbootrestcrud.entity.Employee;
import com.luv2code.springboot.springbootrestcrud.service.EmployeeService;

/**
 * @author Felipe Castro
 *
 */

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// Inject Employee DAO (using constructor injection)
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeDAO) {
		employeeService = theEmployeeDAO;
	}

	// Expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	// Expose "/employees/{employeeId}" and return specific employee information
	@GetMapping("/employees/{employeeId}")
	public Employee getCustomerById(@PathVariable int employeeId) {
		// Checking if id is empty
		if (employeeId == 0) {
			throw new EmployeeNotFoundException("Please enter an id in order to search the employee");
		}

		// Throw exception if the customer brought by the database is null
		Employee foundEmployee = employeeService.findById(employeeId);
		if (foundEmployee == null) {
			throw new EmployeeNotFoundException("Employee id not found: " + employeeId);
		} else {
			return foundEmployee;
		}
	}

	// Expose "/employees/" using POST to save an employee
	@PostMapping("/employees")
	public String addEmployee(@RequestBody Employee theEmployeeToAdd) {
		theEmployeeToAdd.setId(0); // In order to identify the object as not part of the database
		if (theEmployeeToAdd.getFirstName() == null) { // Checking if the object at least is having a first name
			throw new EmployeeNotFoundException("Error at the moment of saving the employee, missing/wrong data");
		}

		employeeService.add(theEmployeeToAdd); // Saving the employee

		if (theEmployeeToAdd.getId() == 0) {
			throw new EmployeeNotFoundException("Error at the moment of saving the employee, missing/wrong data");
		} else {
			return "Employee Added:  " + theEmployeeToAdd.toString();
		}
	}

	// Expose "/employees/{employeeId}" using PUT to update customer
	@PutMapping("/employees")
	public String updateCustomer(@RequestBody Employee theEmployeeToUpdate) {
		// Checking if the id of the employee to update is empty
		if (theEmployeeToUpdate.getId() == 0) {
			throw new EmployeeNotFoundException(
					"Error at the moment of updating the employee, the id of the employee to update can't be empty");
		} else {
			employeeService.update(theEmployeeToUpdate);
			return "Employee Updated " + theEmployeeToUpdate.toString();
		}
	}

	// Expose "/employees/{employeeId}" using DELETE to delete customer
	@DeleteMapping("/employees/{employeeId}")
	public String deleteCustomer(@PathVariable int employeeId) {
		// Checking if the id is not empty
		if (employeeId == 0) {
			throw new EmployeeNotFoundException(
					"Error at the moment of deleting the employee, the id of the employee to update can't be empty");
		} else {
			// Checking if the customer exists before deleting
			Employee tempEmployee = employeeService.findById(employeeId);

			if (tempEmployee == null) {
				throw new EmployeeNotFoundException(
						"Error at the moment of deleting the employee, the id entered is not in our database");
			} else {
				employeeService.delete(tempEmployee);
				return "Employee with id " + employeeId + " deleted";
			}
		}

	}

}