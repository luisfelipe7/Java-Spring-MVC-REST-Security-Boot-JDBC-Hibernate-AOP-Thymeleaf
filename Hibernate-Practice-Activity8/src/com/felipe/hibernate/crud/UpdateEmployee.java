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
public class UpdateEmployee {

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
			// Use the session object to perform the Update

			// Start a transaction
			session.beginTransaction();

			// Performing the Update#1, updating employee with ID = 3
			Employee employeeToUpdate = session.get(Employee.class, 3);
			// Employee is saved on the session, so we just need to call the set method
			employeeToUpdate.setCompany("Universidad Nacional de Costa Rica");

			// Performing the Update#2, updating all the employees having company not
			// defined
			session.createQuery("update Employee set company='NDY' where company='Not Defined Yet'").executeUpdate();

			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Updates performed!!!!");

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
