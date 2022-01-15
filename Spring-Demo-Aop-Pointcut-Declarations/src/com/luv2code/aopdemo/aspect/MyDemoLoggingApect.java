/**
 * 
 */
package com.luv2code.aopdemo.aspect;

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
public class MyDemoLoggingApect {
	
	// This is where we add all of our related advices for logging
	
	// Defining a pointcut expression 
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// Implementing/Calling the pointcut with just calling the method
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=========>>>> Executing @Before advice on addAccount()");	
	}
	
	// Reusing the pointcut with just calling the method
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n=========>>>> Performing API Analytics");
	}

}
