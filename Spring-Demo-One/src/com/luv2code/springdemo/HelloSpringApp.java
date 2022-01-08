/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Felipe Castro
 *
 */
public class HelloSpringApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Creating a simple Spring app:
		
		// Load the spring configuration file
		ClassPathXmlApplicationContext context= 
				new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		// Retrieve bean from spring container
		// I just need to specify the interface class and the context will be in charge of loading the class in charge of implementing
		Coach myFirstCoach = context.getBean("myCoach",Coach.class);
		
		// Call methods on the bean
		System.out.println(myFirstCoach.getDailyWorkout());
		// Calling the method that is using the attribute, Spring "behind the scenes" injected the dependency
		System.out.println(myFirstCoach.getDailyFortune());
		
		// Close the context
		context.close();		
	}

}
