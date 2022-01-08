/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Felipe Castro
 *
 */
public class BeanLifeCycleDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"beanLifeCycle-applicationContext.xml");

		// Retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		// Printing the daily workout
		System.out.println("Daily Workout: " + theCoach.getDailyWorkout());

		// Retrieve bean from spring container
		BaseballCoach myBaseballCoach = context.getBean("myBaseballCoach", BaseballCoach.class);
		BaseballCoach myBaseballCoach2 = context.getBean("myBaseballCoach", BaseballCoach.class);
		// Printing the daily workout
		System.out.println("Daily Workout B1: " + myBaseballCoach.getDailyWorkout());
		System.out.println("Daily Workout B2: " + myBaseballCoach2.getDailyWorkout());
		boolean areObjectsTheSame = (myBaseballCoach == myBaseballCoach2);
		System.out.println("Are the objects the same? Answer: " + areObjectsTheSame);
		System.out.println("B1: " + myBaseballCoach);
		System.out.println("B2: " + myBaseballCoach2);

		// Close the context
		context.close();
	}

}
