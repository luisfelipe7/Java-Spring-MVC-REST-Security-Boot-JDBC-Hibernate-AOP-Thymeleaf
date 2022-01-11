/**
 * 
 */
package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Felipe Castro
 *
 */
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public void initialize(CourseCode constraintAnnotation) {
		// My Custom Code
		coursePrefix = constraintAnnotation.value();
	}

	// theCode is the data entered by the customer
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext arg1) {

		boolean result = false;
		if (theCode != null) {
			result = theCode.startsWith(coursePrefix);
		} else {
			result = true;
		}

		return result;
	}

}
