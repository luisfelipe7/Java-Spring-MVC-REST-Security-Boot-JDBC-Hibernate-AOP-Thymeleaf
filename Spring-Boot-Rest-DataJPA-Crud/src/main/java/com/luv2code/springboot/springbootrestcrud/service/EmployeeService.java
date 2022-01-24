/**
 * 
 */
package com.luv2code.springboot.springbootrestcrud.service;

import java.util.List;

import com.luv2code.springboot.springbootrestcrud.entity.Employee;

/**
 * @author Felipe Castro
 *
 */
public interface EmployeeService {
	
	
	public List<Employee> findAll();
	public Employee findById(int employeeId);
	public void add(Employee employee);
	public void update(Employee employee);
	public void delete(Employee employee);
}
