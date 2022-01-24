/**
 * 
 */
package com.luv2code.springboot.springbootrestcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.springbootrestcrud.entity.Employee;

/**
 * @author Felipe Castro
 *
 */

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// Define field for EntityManager
	private EntityManager entityManager;

	// Setup Constructor Injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create a Query
		Query<Employee> theQuery = currentSession.createQuery("From Employee order by lastName, firstName",
				Employee.class);

		// Execute Query and get result list
		List<Employee> employees = theQuery.getResultList();

		// Return the results
		return employees;
	}

	@Override
	public Employee findById(int employeeId) {
		// Get the current hibernate session
		Session currentSesion = entityManager.unwrap(Session.class);

		// Get the Employee based on the id
		Employee employee = currentSesion.get(Employee.class, employeeId);

		return employee;
	}

	@Override
	public void add(Employee employee) {
		// Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Add the employee
		currentSession.saveOrUpdate(employee);

	}

	@Override
	public void update(Employee employee) {
		// Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Add the employee
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void delete(Employee employee) {
		// Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Delete the employee
		currentSession.delete(employee);
		
	}

}
