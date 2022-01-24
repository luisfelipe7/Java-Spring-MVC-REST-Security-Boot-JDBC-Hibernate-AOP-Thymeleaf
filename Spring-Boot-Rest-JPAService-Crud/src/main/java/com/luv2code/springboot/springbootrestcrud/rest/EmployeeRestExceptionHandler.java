/**
 * 
 */
package com.luv2code.springboot.springbootrestcrud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Felipe Castro
 *
 */

/* With this we can use exception handler in any controller (globally) */
@ControllerAdvice
public class EmployeeRestExceptionHandler {

	// Add exception handling code here

		// Adding an exception handler using @ExceptionHandler

		@ExceptionHandler
		public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc) {

			// Create a StudentErrorResponse
			EmployeeErrorResponse error = new EmployeeErrorResponse();

			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());

			// Return a ResponseEntity
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}

		// Adding another exception handler to catch any exception (catch all)

		@ExceptionHandler
		public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc) {
			// Create a StudentErrorResponse
			EmployeeErrorResponse error = new EmployeeErrorResponse();

			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(
					"Invalid request, the information entered is not valid for the request that you are trying to make");
			error.setTimeStamp(System.currentTimeMillis());

			// Return a ResponseEntity
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}

	}