/**
 * 
 */
package com.luv2code.springboot.springbootrestcrud.rest;

/**
 * @author Felipe Castro
 *
 */
public class EmployeeErrorResponse {
	
	private int status;
	private String message;
	private long timeStamp;
	
	public EmployeeErrorResponse() {
		// Constructor without parameters
	}
	
	/**
	 * @param status
	 * @param message
	 * @param timeStamp
	 */
	public EmployeeErrorResponse(int status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	

}
