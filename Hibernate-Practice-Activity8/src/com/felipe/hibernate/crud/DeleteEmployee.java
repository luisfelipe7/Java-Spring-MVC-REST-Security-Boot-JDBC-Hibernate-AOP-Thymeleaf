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
public class DeleteEmployee {

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
			// Use the session object to perform the Delete

			// Start a transaction
			session.beginTransaction();

			// Performing the Delete#1, deleting employee with ID = 1
			Employee employeeToUpdate = session.get(Employee.class, 1);
			// Employee is saved on the session, so we just need to call the delete method
			session.delete(employeeToUpdate);

			// Performing the Delete#2, Delete all the employees having company NDY
			session.createQuery("delete from Employee where company='NDY'").executeUpdate();

			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Deletes performed!!!!");

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
