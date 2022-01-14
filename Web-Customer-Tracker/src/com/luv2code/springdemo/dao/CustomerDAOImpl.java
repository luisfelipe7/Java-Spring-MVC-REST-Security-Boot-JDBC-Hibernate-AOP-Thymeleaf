/**
 * 
 */
package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

/**
 * @author Felipe Castro
 *
 */
/* In order to recognize these implementations */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// Get the current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();

		// Create a Query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName, firstName",
				Customer.class);

		// Execute a Query and get Result List
		List<Customer> customers = theQuery.getResultList();

		// Return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// Get the current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();

		// Saving the customer or Updating depending if the id is defined
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Obtaining the customer
		Customer theCustomer = currentSession.get(Customer.class, theId);

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Delete Object with Primary Key
		Query theQuery= currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);

		// Delete the customer
		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> getCustomersByName(String nameToSearch) {
		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create the Query
		Query<Customer> theQuery = currentSession.createQuery("from Customer where firstName like :nameToSearch");
		theQuery.setParameter("nameToSearch","%"+nameToSearch+"%");
		
		//Execute the Query and Get Result List
		List<Customer> customers=theQuery.getResultList();
		
		return customers;
	}

}
