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
public class AfterReturningDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Read Spring Config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// Get the Bean from Spring Container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		
		// Call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		
		// Display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");


		// Close the Context
		context.close();
	}

}
