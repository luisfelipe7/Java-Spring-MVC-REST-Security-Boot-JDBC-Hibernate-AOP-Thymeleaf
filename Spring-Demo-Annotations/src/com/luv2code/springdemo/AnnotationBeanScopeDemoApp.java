/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Felipe Castro
 *
 */
public class AnnotationBeanScopeDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Load Spring Config File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

		// Check if they are the same
		boolean result = (theCoach == alphaCoach);

		// Print out the results
		System.out.println("\n Poiting to the same object: " + result);
		System.out.println("\n Memory location for theCoach: " + theCoach);
		System.out.println("\n Memory location for alphaCoach: " + alphaCoach);

		// Retrieve bean from spring container but using protoype scope
		Coach theCoach2 = context.getBean("boxingCoach", Coach.class);
		Coach alphaCoach2 = context.getBean("boxingCoach", Coach.class);

		// Check if they are the same
		boolean result2 = (theCoach2 == alphaCoach2);

		// Print out the results
		System.out.println("\n Poiting to the same object: " + result2);
		System.out.println("\n Memory location for theCoach2: " + theCoach2);
		System.out.println("\n Memory location for alphaCoach2: " + alphaCoach2);
		
		// Closing the context
		context.close();

	}

}
