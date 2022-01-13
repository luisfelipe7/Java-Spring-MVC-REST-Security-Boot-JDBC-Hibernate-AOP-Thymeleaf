/**
 * 
 */
package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

/**
 * @author Felipe Castro
 *
 */
public class EagerLazyDemo {

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
			// Option #2: Hibernate Query with HQL
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id=:theInstructorId",
					Instructor.class);
			// Set Parameter on Query
			query.setParameter("theInstructorId", theId);

			// Execute Query and Get Instructor
			Instructor tempInstructor = query.getSingleResult();

			System.out.println("MyApplication: Instructor: " + tempInstructor.toString());

			// Commit transaction
			session.getTransaction().commit();

			// Close the session
			session.close();
			
			System.out.println("MyApplication: The session is now closed!\n");
			
			// Get Courses for the Instructor
			System.out.println("MyApplication: Courses: "+tempInstructor.getCourses());

		} finally {
			// Add Clean Up Code
			session.close();

			factory.close();
		}

	}

}
