/**
 * 
 */
package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

/**
 * @author Felipe Castro
 *
 */
public class AfterThrowingDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Read Spring Config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// Get the Bean from Spring Container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		List<Account> theAccounts = null;

		// Call method to find the accounts
		try {
			// Add a boolean flag to simulate exceptions
			boolean tripWire=true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program ... Caugh Exception " + e);
			System.out.println("Exception : " + e.getMessage());
		}

		// Display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");

		// Close the Context
		context.close();
	}

}
