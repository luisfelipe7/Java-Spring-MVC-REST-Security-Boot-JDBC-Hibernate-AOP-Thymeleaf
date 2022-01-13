/**
 * 
 */
package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

/**
 * @author Felipe Castro
 *
 */
public class FetchJoinDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// Use the session object to save Java Object

			// Start a transaction
			session.beginTransaction();

			// Get the Instructor from DB
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("MyApplication: Instructor: " + tempInstructor.toString());

			// Commit transaction
			session.getTransaction().commit();

			// Close the session
			session.close();
			
			// Option #1: Call getter method while the session is open

			// Get Courses from the instructor
			System.out.println("MyApplication: Courses: " + tempInstructor.getCourses());

			System.out.println("MyApplication: Done!");

		} finally {
			// Add Clean Up Code
			session.close();

			factory.close();
		}

	}

}
