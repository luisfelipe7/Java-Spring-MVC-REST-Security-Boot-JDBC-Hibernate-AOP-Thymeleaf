/**
 * 
 */
package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

/**
 * @author Felipe Castro
 *
 */
public class AroundWithLoggerDemoApp {

	/**
	 * @param args
	 */
	// Creating the logger
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		// Read Spring Config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// Get the Bean from Spring Container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");

		myLogger.info("\nCalling getFortune");

		myLogger.info("\n");

		String data = theFortuneService.getFortune();

		myLogger.info("\n My fortune is: " + data);

		myLogger.info("Finished");

		// Close the Context
		context.close();
	}

}
