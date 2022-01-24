package com.luv2code.springboot.springbootrestcrud.dao;

import java.util.List;

import com.luv2code.springboot.springbootrestcrud.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	public Employee findById(int employeeId);
	public void add(Employee employee);
	public void update(Employee employee);
	public void delete(Employee employee);

}
