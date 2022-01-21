/**
 * 
 */
package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Felipe Castro
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {

			// Create Object Mapper

			ObjectMapper mapper = new ObjectMapper();

			// Read JSON File and Map/Connection to Java POJO:
			// data/sample-lite.json

			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);

			// Print first name and last name
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			// Print out address: Street and City
			Address tempAddress = theStudent.getAddress();

			System.out.println("Street = " + tempAddress.getStreet());
			System.out.println("City = " + tempAddress.getCity());
			
			// Print out Languages
			for (String tempLanguage : theStudent.getLanguages()) {
				System.out.println("Language: "+tempLanguage);
			}

			// Print full information
			System.out.println("Student Full information: " + theStudent.toString());

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
