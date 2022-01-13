/**
 * 
 */
package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

/**
 * @author Felipe Castro
 *
 */
public class DeleteDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// Use the session object to save Java Object

			// Start a transaction
			session.beginTransaction();

			// Get Instructor by Primary Key/ ID
			int idOfInstructor = 1;
			Instructor tempInstructor = session.get(Instructor.class, idOfInstructor);

			System.out.println("Found Instructor: " + tempInstructor);

			// Delete the Instructor
			if (tempInstructor != null) {
				System.out.println("Deleting: " + tempInstructor);
				// Note: Will also delete associated "details" object
				// because of CascadeType.ALL
				session.delete(tempInstructor);
				System.out.println("Instructor Deleted without Issues");
			}

			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
