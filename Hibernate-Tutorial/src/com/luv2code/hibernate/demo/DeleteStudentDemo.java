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
public class DeleteStudentDemo {

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
			Student tempStudent = new Student("Ronald", "Mustang", "ronald@gmail.com");

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
			
			
			// DELETING THE SAVED STUDENT
			// Creating new session
			session=factory.getCurrentSession();
			// Start a transaction
			session.beginTransaction();
			// Executing the delete
			session.delete(tempStudent);		
			// Executing Query to delete all the people starting on their email with a o
			session.createQuery("delete from Student where email like 'o%'").executeUpdate();
			
			// Commit Transaction
			session.getTransaction().commit();
		
		} finally {
			factory.close();
		}

	}

}
