/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Felipe Castro
 *
 */
public class SwimJavaConfigDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Read Spring Configuration File
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// Get the bean from the spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

		// Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// Call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// Displaying the information
		theCoach.displayInformation();
		
		// Close the context
		context.close();
	}

}