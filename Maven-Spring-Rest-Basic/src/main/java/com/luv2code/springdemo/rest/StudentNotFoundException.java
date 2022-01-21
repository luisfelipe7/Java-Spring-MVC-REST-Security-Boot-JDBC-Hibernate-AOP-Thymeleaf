/**
 * 
 */
package com.luv2code.springdemo.rest;

/**
 * @author Felipe Castro
 *
 */
public class StudentNotFoundException extends RuntimeException {

	/**
	 * @param message
	 * @param cause
	 */
	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public StudentNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
