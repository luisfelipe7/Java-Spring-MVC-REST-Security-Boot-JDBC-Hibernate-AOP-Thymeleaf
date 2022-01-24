/**
 * 
 */
package com.luv2code.springboot.springbootrestcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.springbootrestcrud.dao.EmployeeDAO;
import com.luv2code.springboot.springbootrestcrud.entity.Employee;

/**
 * @author Felipe Castro
 *
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
	// Injecting the EmployeeDAO via constructor
	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpalImpl") EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int employeeId) {
		return employeeDAO.findById(employeeId);
	}

	@Override
	@Transactional
	public void add(Employee employee) {
		employeeDAO.add(employee);
	}

	@Override
	@Transactional
	public void update(Employee employee) {
		employeeDAO.update(employee);
	}

	@Override
	@Transactional
	public void delete(Employee employee) {
		employeeDAO.delete(employee);
	}

}
