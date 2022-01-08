/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Felipe Castro
 *
 */
public class SetterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve the bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

		// Call methods on the bean
		System.out.println("Daily Fortune "+theCoach.getDailyFortune());
		// Calling our new method to get the literal values
		System.out.println("Email: "+theCoach.getEmailAddress());
		System.out.println("Team: "+theCoach.getTeam());
		
		// Retrieving the bean from spring container for the new class
		SoccerCoach theCoach2 = context.getBean("mySoccerCoach",SoccerCoach.class);
		
		// Call methods on the bean
		System.out.println("Daily Fortune "+theCoach2.getDailyFortune());
		System.out.println("Random Fortune "+theCoach2.getRandomDailyFortune());
		// Calling our new method to get the literal values
		System.out.println("Email: "+theCoach2.getEmailAddress());
		System.out.println("Team: "+theCoach2.getTeam());

		// Close the context
		context.close();
	}

}
