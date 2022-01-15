/**
 * 
 */
package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Felipe Castro
 *
 */

@Aspect
@Component
@Order(5)
public class MyDemoLoggingApect {

	// This is where we add all of our related advices for logging
	
	// Implementing/Calling the pointcut with just calling the method
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.onlyBussinessMethodsDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=========>>>> Executing @Before advice on addAccount()");
	}

}
