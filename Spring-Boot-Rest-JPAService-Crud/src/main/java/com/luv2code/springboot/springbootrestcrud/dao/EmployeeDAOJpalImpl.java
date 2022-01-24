/**
 * 
 */
package com.luv2code.springboot.springbootrestcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.luv2code.springboot.springbootrestcrud.entity.Employee;

/**
 * @author Felipe Castro
 *
 */

@Repository
public class EmployeeDAOJpalImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOJpalImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// Create a Query
		Query theQuery = entityManager.createQuery("from Employee order by firstName, lastName");

		// Execute the Query and get result list
		List<Employee> employees = theQuery.getResultList();

		// Return the results
		return employees;
	}

	@Override
	public Employee findById(int employeeId) {
		// Get Employee
		Employee theEmployee = entityManager.find(Employee.class, employeeId);

		// Return the Employee
		return theEmployee;
	}

	@Override
	public void add(Employee employee) {
		// Saver or update the employee, if id is 0 so it will save and if not it will
		// update
		Employee dbEmployee = entityManager.merge(employee);
		// Update with id from db, so we can get generated id for save/insert
		employee.setId(dbEmployee.getId());

	}

	@Override
	public void update(Employee employee) {
		// Saver or update the employee, if id is 0 so it will save and if not it will
		// update
		Employee dbEmployee = entityManager.merge(employee);
		// Update with id from db, so we can get generated id for save/insert
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void delete(Employee employee) {
		// Delete object by Id
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		// Setting the id on the Query
		theQuery.setParameter("employeeId", employee.getId());
		// Executing the Query
		theQuery.executeUpdate();

	}

}
