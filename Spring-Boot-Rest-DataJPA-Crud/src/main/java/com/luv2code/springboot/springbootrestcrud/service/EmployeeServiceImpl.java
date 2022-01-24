/**
 * 
 */
package com.luv2code.springboot.springbootrestcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.springbootrestcrud.dao.EmployeeRepository;
import com.luv2code.springboot.springbootrestcrud.entity.Employee;

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
		return employeeRepository.findAll();
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
