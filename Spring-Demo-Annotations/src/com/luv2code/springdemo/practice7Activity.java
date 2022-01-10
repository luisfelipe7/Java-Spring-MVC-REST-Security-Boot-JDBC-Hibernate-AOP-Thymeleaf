/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Felipe Castro
 *
 */
public class practice7Activity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Load the config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

		// Retrieve the bean
		Coach theCoach = context.getBean("taekwondoCoach", Coach.class);

		// Call the methods
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

	}

}
