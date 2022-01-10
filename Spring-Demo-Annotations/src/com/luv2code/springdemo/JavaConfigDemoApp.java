/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Felipe Castro
 *
 */
public class JavaConfigDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Read Spring Configuration File
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// Get the bean from the spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		// Get the bean using the default bean id
		BoxingCoach theCoach2 = context.getBean("boxingCoach", BoxingCoach.class);

		// Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach2.getDailyWorkout());

		// Call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach2.getDailyFortune());

		// Returning the information from boxing
		System.out.println(theCoach2.information());
		
		// Close the context
		context.close();
	}

}