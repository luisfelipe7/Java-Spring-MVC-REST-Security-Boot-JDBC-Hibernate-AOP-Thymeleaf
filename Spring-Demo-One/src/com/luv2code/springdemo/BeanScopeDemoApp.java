/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Felipe Castro
 *
 */
public class BeanScopeDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Load the spring configuration file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// Retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		// Check if they are pointing to the same area in memory
		boolean result = (theCoach == alphaCoach);
		
		// Print out the results
		System.out.println("\nPointing to the same object? Answer: "+result);
		System.out.println("\nMemory location for theCoach: "+theCoach);
		System.out.println("\nMemory location for the alphaCoach: "+alphaCoach+" \n");
		
		//Close the context
		context.close();
	}

}
