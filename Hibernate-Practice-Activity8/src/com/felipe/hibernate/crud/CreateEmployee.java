/**
 * 
 */
package com.felipe.hibernate.crud;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.felipe.hibernate.crud.entity.Employee;

/**
 * @author Felipe Castro
 *
 */
public class CreateEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// Create Session
		Session session= factory.getCurrentSession();
		
		try {
			// Use the session object to save Java Object
			
			// Create employee object
			System.out.println("Creating a new employee object....");
			Employee tempEmployee = new Employee("Felipe","Castro","Not Defined Yet");			
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the employee object
			System.out.println("Saving the employee.....");
			session.save(tempEmployee);
			
			// Commit transaction
			session.getTransaction().commit();
			
			// After the commit the employee is saved
			System.out.println("The employee was saved!!!!");
			System.out.println("Here is the information of the employee "+tempEmployee.toString());
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	
	}

}
