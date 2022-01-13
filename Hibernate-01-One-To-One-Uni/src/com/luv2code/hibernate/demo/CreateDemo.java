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
public class CreateDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// Create Session
		Session session= factory.getCurrentSession();
		
		try {
			// Use the session object to save Java Object
			
			// Create the objects
			Instructor tempInstructor = new Instructor("Chad","Darby","darby@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http//www/luv2code.com/youtube","Luv 2 Code!!!");
			
				
			// Associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the instructor, this will also save the InstructorDetail because the Cascade Type All
			System.out.println("Saving instructor: "+tempInstructor);
			session.save(tempInstructor);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
