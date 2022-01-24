/**
 * 
 */
package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

/**
 * @author Felipe Castro
 *
 */

// Just indicate the class and the type of the primary id
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// That's it, no need to write any code, the JPA Repository will generate these
	// CRUD methods:
	// findAll()
	// findById()
	// save()
	// deleteById()
	// And others....
	
	// Adding a custom method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
