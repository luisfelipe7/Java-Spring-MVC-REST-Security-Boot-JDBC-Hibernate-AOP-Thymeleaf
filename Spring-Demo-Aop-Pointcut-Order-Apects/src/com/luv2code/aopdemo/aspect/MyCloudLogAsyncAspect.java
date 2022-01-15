/**
 * 
 */
package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Felipe Castro
 *
 */

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	// Reusing the pointcut with just calling the method
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.onlyBussinessMethodsDaoPackage()")
	public void logToCloudAsync() {
		System.out.println("\n=========>>>> Logging to Cloud in Async Fashion");
	}
}
