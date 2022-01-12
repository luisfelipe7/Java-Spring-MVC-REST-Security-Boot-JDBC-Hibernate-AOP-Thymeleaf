/**
 * 
 */
package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

/**
 * @author Felipe Castro
 *
 */
public class QueryStudentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// Use the session object to query

			// Start a transaction
			session.beginTransaction();

			// Query #1
			// Perform the Query using HQL (Hibernate Query Language) to obtain all students
			List<Student> theStudents = session.createQuery("from Student").getResultList(); // Getting all the students															// objects
			// Display the students
			displayStudents(theStudents);

			// Query #2
			// Perform the Query using HQL to obtain students where last name contains a c
			theStudents = session.createQuery("from Student s where s.lastName like '%c%'").getResultList();
			// Display the students
			displayStudents(theStudents);
			
			// Query #3
			// Perform the Query using HQL to obtain students where lastName=Facio or firstName=Yenifer
			theStudents = session.createQuery("from Student s where s.lastName='Facio' or s.firstName='Yenifer'").getResultList();
			// Display the students
			displayStudents(theStudents);
			
			// Query #4
			// Perform the Query using HQL to obtain students where email ends with gmail.com
			theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
			// Display the students
			displayStudents(theStudents);
			
			
			
			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent.toString());
		}
	}

}
