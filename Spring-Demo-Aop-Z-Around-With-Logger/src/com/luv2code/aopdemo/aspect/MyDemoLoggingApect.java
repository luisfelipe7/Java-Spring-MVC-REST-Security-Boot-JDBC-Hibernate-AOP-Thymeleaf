/**
 * 
 */
package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;

/**
 * @author Felipe Castro
 *
 */

@Aspect
@Component
@Order(5)
public class MyDemoLoggingApect {

	// Creating the logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// This is where we add all of our related advices for logging

	// Adding a new advice for @Around on the findAccounts advice
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		// Print out which method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Executing @Around on method: " + method);

		// Get begin timestamp
		long begin = System.currentTimeMillis();

		// Now, let's execute the method
		myLogger.info("\n ======> Started the execution of the method " + method);
		Object result = theProceedingJoinPoint.proceed();

		// Get end timestamp
		myLogger.info("\n ======> This was executed because the method " + method + " ended executing");
		myLogger.info("\n ======> The result of the method is " + result);
		long end = System.currentTimeMillis();

		// Compute duration and display it
		long duration = end - begin;
		myLogger.info("\n======> Duration: " + duration / 1000.0 + " seconds");

		return result;
	}

	// Adding a new advice for @After on the findAccounts advice
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdivce(JoinPoint theJoinPoint) {
		// Print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Executing @After (Finally) on method: " + method);
	}

	// Adding a new advice for @Afterthrowing on the findAccounts advice
	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		// Print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Executing @AfterThrowing on method: " + method);

		// Log the Exception
		myLogger.info("\n======>>> The exception is: " + theExc);
	}

	// Adding a new advice for @AfterReturning on the findAccounts method

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// Print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Executing @AfterReturning on method: " + method);

		// Print out the results of the method call
		myLogger.info("\n======>> Result is: " + result);

		// Modify the "result" list: Add, Remove, Update, Etc
		// Post-Processing the data .. let's modify it
		// Converting the account names to uppercase
		convertAccountNamesToUpperCase(result);

		// Print out the results of the method call
		myLogger.info("\n======>> Result is: " + result);
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
		myLogger.info("\n=========>>>> Executing @Before advice on addAccount()");

		// Display the Method Signature thanks to the JoinPoint
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		myLogger.info("Method: " + methodSig);

		// Display the Method Arguments thanks to the JoinPoint
		// Get Arguments
		Object[] args = theJoinPoint.getArgs();

		// Loop through the arguments
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());

			if (tempArg instanceof Account) {
				// Downcast and print Account specific information
				Account tempAccount = (Account) tempArg;
				myLogger.info("Account Information: " + tempAccount.toString());

			}
		}
	}

}
