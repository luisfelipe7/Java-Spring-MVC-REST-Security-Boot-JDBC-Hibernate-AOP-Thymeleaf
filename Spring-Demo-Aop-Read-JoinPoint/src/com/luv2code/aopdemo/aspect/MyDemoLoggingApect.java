/**
 * 
 */
package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
