/**
 * 
 */
package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Felipe Castro
 *
 */

@Aspect
@Component
public class CRMLoggingAspect {
	// Setup Logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// Setup Pointcut Declarations - Match Any Method Type, Any Class and Multiple
	// Parameters inside that Package
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	// Add @Before Advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// Display Method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======> In @Before: Calling Method: " + theMethod);
		// Display the arguments to the method
		// Get the Arguments
		Object[] args = theJoinPoint.getArgs();
		// Loop through and display arguments
		for (Object tempArg : args) {
			myLogger.info("========> Argument: " + tempArg);
		}
	}

	// Add @AfterReturning Advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		// Display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======> In @AfterReturning: from method: " + theMethod);

		// Display data returned
		myLogger.info("======> Result: " + theResult);

	}

}
