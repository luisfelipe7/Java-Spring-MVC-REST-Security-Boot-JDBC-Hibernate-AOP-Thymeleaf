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
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

/**
 * @author Felipe Castro
 *
 */
public class CreateCourseAndStudentsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// Use the session object to save Java Object

			// Start a transaction
			session.beginTransaction();
	
			// Create a Course
			Course tempCourse = new Course("Python for Beginners");
			
			// Save the Course
			System.out.println("\nSaving the course ...");
			session.save(tempCourse);
			System.out.println("Saved the course: "+tempCourse);
			
			// Create the students
			Student tempStudent1 = new Student("Luis","Doe","luis@luv2code.com");
			Student tempStudent2 = new Student("Yen","Public","yen@luv2code.com");
			
			// Add the students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// Save the students
			System.out.println("\nSaving students ....");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students: "+tempCourse.getStudents());
				
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
