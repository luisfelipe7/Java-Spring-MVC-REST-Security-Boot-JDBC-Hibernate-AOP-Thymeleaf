/**
 * 
 */
package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Felipe Castro
 *
 */

@Aspect
@Component
public class MyDemoLoggingApect {
	
	// This is where we add all of our related advices for logging
	
	// Let's start with an @Before advice, we need to put the name of the method (theAccountDAO.addAccount();)
	// The expression format is: public (modifier optional) boolean (return type to match) isPrime (name of the method to match)

	// 	@Before("execution(public void add*())") --> This will match all the methods having add*	
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(*,*))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=========>>>> Executing @Before advice on addAccount()");	
	}

}
