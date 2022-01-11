/**
 * 
 */
package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.CourseCode;

/**
 * @author Felipe Castro
 *
 */
public class Customer {

	/* Applying the validations thanks to the hibernate validator */

	private String firstName;

	@NotNull(message = "This field is required")
	@Size(min = 1, message = "This field is required")
	private String lastName;

	@NotNull(message = "This field is required")
	@Min(value = 0, message = "The value must be greater than or equal to zero")
	@Max(value = 10, message = "The value must be less than or equal to 10")
	private Integer freePasses;

	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 Characters/Digits")
	private String postalCode;
	
	@CourseCode(value="TOPS",message="Must start with TOPS")
	private String courseCode;

	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the freePasses
	 */
	public Integer getFreePasses() {
		return freePasses;
	}

	/**
	 * @param freePasses the freePasses to set
	 */
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	

}
