/**
 * 
 */
package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Felipe Castro
 *
 */

@Aspect
public class LuvAopExpressions {

	// Defining a pointcut expression
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// Create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getDaoPackage() {
	}

	// Create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setDaoPackage() {
	}

	// Create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getDaoPackage() || setDaoPackage())")
	public void onlyBussinessMethodsDaoPackage() {
	}

}
