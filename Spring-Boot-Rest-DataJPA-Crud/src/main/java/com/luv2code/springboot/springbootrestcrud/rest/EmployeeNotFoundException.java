/**
 * 
 */
package com.luv2code.springboot.springbootrestcrud.rest;

/**
 * @author Felipe Castro
 *
 */
public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * @param message
	 * @param cause
	 */
	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public EmployeeNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
