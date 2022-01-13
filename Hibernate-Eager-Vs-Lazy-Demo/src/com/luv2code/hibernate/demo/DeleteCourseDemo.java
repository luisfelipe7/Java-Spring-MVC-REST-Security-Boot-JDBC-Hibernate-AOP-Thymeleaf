/**
 * 
 */
package com.luv2code.hibernate.demo;

import java.util.List;

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
public class DeleteCourseDemo {

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
			
			// Get a Course
			int idCourse =10;
			Course tempCourse = session.get(Course.class, idCourse);
			
			// Delete the Course
			System.out.println("Deleting course: "+tempCourse);
			
			session.delete(tempCourse);
		
			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			// Add Clean Up Code
			session.close();

			factory.close();
		}

	}

}
