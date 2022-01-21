/**
 * 
 */
package com.luv2code.springdemo.rest;

/**
 * @author Felipe Castro
 *
 */
public class CustomerNotFoundException extends RuntimeException {

	/**
	 * @param message
	 * @param cause
	 */
	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public CustomerNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
