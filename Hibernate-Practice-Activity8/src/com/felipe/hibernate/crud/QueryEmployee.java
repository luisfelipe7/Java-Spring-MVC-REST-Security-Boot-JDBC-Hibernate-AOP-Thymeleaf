/**
 * 
 */
package com.felipe.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.felipe.hibernate.crud.entity.Employee;

/**
 * @author Felipe Castro
 *
 */
public class QueryEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// Use the session object to perform the Query

			// Start a transaction
			session.beginTransaction();

			// Performing the Query#1, getting all the employees
			List<Employee> employeesInDB = session.createQuery("from Employee").getResultList();

			// Printing the elements
			System.out.println("Printing all the employees");
			printList(employeesInDB);

			// Performing the Query#1, getting all the employees
			employeesInDB = session.createQuery("from Employee where company='Not Defined Yet'").getResultList();

			// Printing the elements
			System.out.println("Printing all the employees having the company not defined");
			printList(employeesInDB);

			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Queries performed!!!!");

		} finally {
			factory.close();
		}
	}

	private static void printList(List<Employee> employeesInDB) {
		for (Employee employeeInDB : employeesInDB) {
			System.out.println("Employee in DB :");
			System.out.println(employeeInDB.toString());
		}
	}

}
