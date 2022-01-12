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
public class PrimaryKeyDemo {

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

			// Create 3 student objects
			System.out.println("Creating a new 3 student objects....");
			Student tempStudent1 = new Student("Yenifer", "Esquivel", "yenifer@gmail.com");
			Student tempStudent2 = new Student("Rodrigo", "Facio", "rodrigo@gmail.com");
			Student tempStudent3 = new Student("Manuel", "Cespedes", "manuel@gmail.com");

			// Start a transaction
			session.beginTransaction();

			// Save the student object
			System.out.println("Saving the 3 students.....");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
