/**
 * 
 */
package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

/**
 * @author Felipe Castro
 *
 */
public class ReadStudentDemo {

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
			// Use the session object to save Java Object

			// Create student object
			System.out.println("Creating a new student object....");
			Student tempStudent = new Student("Donald", "John", "donald@gmail.com");

			// Start a transaction
			session.beginTransaction();

			// Save the student object
			System.out.println("Saving the student.....");
			System.out.println(tempStudent.toString());
			session.save(tempStudent);

			// Commit transaction
			session.getTransaction().commit();

			// READING THE SAVED STUDENT
			System.out.println("Saved student. Generate id: " + tempStudent.getId());

			// Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// Retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get Complete: " + myStudent);

			// Commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
