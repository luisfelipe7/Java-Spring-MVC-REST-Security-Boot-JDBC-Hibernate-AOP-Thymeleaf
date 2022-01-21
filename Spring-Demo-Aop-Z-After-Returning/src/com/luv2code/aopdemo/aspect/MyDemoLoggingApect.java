/**
 * 
 */
package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

/**
 * @author Felipe Castro
 *
 */

@Aspect
@Component
@Order(5)
public class MyDemoLoggingApect {

	// This is where we add all of our related advices for logging

	// Adding a new advice for @AfterReturning on the findAccounts method

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// Print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterReturning on method: " + method);

		// Print out the results of the method call
		System.out.println("\n======>> Result is: " + result);

		// Modify the "result" list: Add, Remove, Update, Etc
		// Post-Processing the data .. let's modify it
		// Converting the account names to uppercase
		convertAccountNamesToUpperCase(result);

		// Print out the results of the method call
		System.out.println("\n======>> Result is: " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		// Loop through accounts
		for (Account tempAccount : result) {
			// Updating name
			tempAccount.setName(tempAccount.getName().toUpperCase());
		}

	}

	// Implementing/Calling the pointcut with just calling the method
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.onlyBussinessMethodsDaoPackage()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=========>>>> Executing @Before advice on addAccount()");

		// Display the Method Signature thanks to the JoinPoint
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("Method: " + methodSig);

		// Display the Method Arguments thanks to the JoinPoint
		// Get Arguments
		Object[] args = theJoinPoint.getArgs();

		// Loop through the arguments
		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				// Downcast and print Account specific information
				Account tempAccount = (Account) tempArg;
				System.out.println("Account Information: " + tempAccount.toString());

			}
		}
	}

}
