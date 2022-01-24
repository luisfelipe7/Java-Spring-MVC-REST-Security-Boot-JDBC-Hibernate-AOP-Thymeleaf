/**
 * 
 */
package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

/**
 * @author Felipe Castro
 *
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
	// Injecting the EmployeeDAO via constructor
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int employeeId) {
		Optional<Employee> result = employeeRepository.findById(employeeId);
		Employee theEmployee=null;
		
		if(result.isPresent()) { // Checking if something was found
			theEmployee= result.get(); // If the value was found we get() the Employee
		}
		return theEmployee;
	}

	@Override
	public void add(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void update(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void delete(Employee employee) {
		employeeRepository.deleteById(employee.getId());
	}

}
