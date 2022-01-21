/**
 * 
 */
package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

/**
 * @author Felipe Castro
 *
 */
public class AroundDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Read Spring Config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// Get the Bean from Spring Container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain Program: AroundDemoApp");

		System.out.println("\nCalling getFortune");

		System.out.println("\n");

		String data = theFortuneService.getFortune();

		System.out.println("\n My fortune is: " + data);

		System.out.println("Finished");

		// Close the Context
		context.close();
	}

}
