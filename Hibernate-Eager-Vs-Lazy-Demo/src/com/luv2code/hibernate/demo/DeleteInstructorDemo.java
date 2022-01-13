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
public class DeleteInstructorDemo {

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
			
			// Get a Instructor
			int idInstructor =2;
			Instructor tempInstructor = session.get(Instructor.class, idInstructor);
			
			// Delete the relation with the courses related before delete the instructor
			List<Course> coursesToRemoveRelation=tempInstructor.getCourses();
			for(Course courseToRemove: coursesToRemoveRelation) {
				courseToRemove.setInstructor(null);
			}
			
			
			// Delete the Instructor
			System.out.println("Deleting instructor: "+tempInstructor);
			
			session.delete(tempInstructor);
		
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
