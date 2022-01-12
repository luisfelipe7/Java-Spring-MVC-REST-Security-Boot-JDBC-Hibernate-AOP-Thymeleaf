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
public class UpdateStudentDemo {

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
			Student tempStudent = new Student("Tony", "Hill", "ton@gmail.com");

			// Start a transaction
			session.beginTransaction();

			// Save the student object
			System.out.println("Saving the student.....");
			System.out.println(tempStudent.toString());
			session.save(tempStudent);

			// Commit transaction
			session.getTransaction().commit();

			// READING THE SAVED STUDENT
			System.out.println("Saved student. Generated id: " + tempStudent.getId());

			// Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			
			
			// UPDATING the saved student
			System.out.println("\nGetting student with id to update: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get Complete: " + myStudent);
			System.out.println("Updating the student....");
			myStudent.setEmail("tony@gmail.com");
			
			System.out.println("Updating on the database with the commit");
			// Commit the transaction
			session.getTransaction().commit();
			
			
			// DOING A MASSIVE UPDATE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Updating email for all people containing an 'o' in their last name
			System.out.println("Updating email for all people containing an 'o' in their last name");
			session.createQuery("update Student set email='o@gmail.com' where lastName like '%o%' ").executeUpdate();
			
			System.out.println("Updating on the database with the commit");
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
