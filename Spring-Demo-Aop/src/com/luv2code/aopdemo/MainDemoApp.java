/**
 * 
 */
package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

/**
 * @author Felipe Castro
 *
 */
public class MainDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Read Spring Config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// Get the Bean from Spring Container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		Account theAccount = new Account("Simple Account", "L1");

		// Call the Business Method
		System.out.println("Calling the Bussiness Methods: ");
		theAccountDAO.addAccount(theAccount, true);
		theAccountDAO.doWork();
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

		// Call the Business Method again to verify the aspect is executing again
		System.out.println("\nCalling the Bussiness Methods Again: ");
		theAccountDAO.addAccount(theAccount, false);
		theMembershipDAO.addSillyMember();

		// Close the Context
		context.close();

	}

}
