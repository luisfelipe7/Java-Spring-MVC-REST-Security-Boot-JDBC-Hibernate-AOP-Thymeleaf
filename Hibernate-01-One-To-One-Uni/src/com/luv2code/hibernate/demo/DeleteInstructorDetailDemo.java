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
public class DeleteInstructorDetailDemo {

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

			// Get InstructorDetail by Primary Key/ ID
			int idOfInstructorDetail = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, idOfInstructorDetail);
			
			// Print Instructor Detail
			System.out.println("Found InstructorDetail: " + tempInstructorDetail.toString());

			// Print Associated Instructor
			System.out.println("Found InstructorDetail, this is the associated Instructor: " + tempInstructorDetail.getInstructor().toString());
			
			// DELETE SECTION
			// Now let's Delete the Instructor Detail
			System.out.println("Deleting tempInstructoDetail: "+tempInstructorDetail);
			// We need to break bi-directional link to just remove Instructor Detail and not remove the Instructor
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			// This will delete the associated instructor if the Cascade Type REMOVE is included
			session.delete(tempInstructorDetail);
			
			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		}
		catch(Exception exc) {
			System.out.println("Exception message: "+exc.getMessage());
			exc.printStackTrace();
		}
		
		finally {
			// Handle Connection Leak Issue
			session.close();
			factory.close();
		}

	}

}
