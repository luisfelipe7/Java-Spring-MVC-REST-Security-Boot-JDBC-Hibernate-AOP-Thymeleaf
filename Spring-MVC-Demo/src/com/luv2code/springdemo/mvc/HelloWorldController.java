/**
 * 
 */
package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Felipe Castro
 *
 */

@Controller
@RequestMapping("/hello") // This will make all the urls having this format /hello/... , /hello/.. and so on
public class HelloWorldController {

	// 1) Method to show the initial HTML form
	// Request Map to assign an url
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// 2) Method to process the HTML form
	// Request Map to assign an url
	@RequestMapping("/confirmationForm")
	public String confirmationForm() {
		return "confirmation-form";
	}

	// 3) New method to read form data and add data to the model
	@RequestMapping("/confirmationFormTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		// a) Read the request parameter from the HTML form
		String theName = request.getParameter("studentName");

		// b) Convert the data to all caps
		theName = theName.toUpperCase();

		// c) Create the message
		String result = "Yo! " + theName;

		// d) Set message on the model
		model.addAttribute("message", result);

		return "confirmation-form";
	}
	
	// 4) New method to read form data and add data to the model using Request Parameter
		@RequestMapping("/confirmationFormThree")
		public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
			// a) Read the request parameter from the HTML form
			// THIS IS NO LONGER REQUIRED -> String theName = request.getParameter("studentName");
			// WE ALREADY HAVE THE NAME COMING AS A PARAMETER

			// b) Convert the data to all caps
			theName = theName.toUpperCase();

			// c) Create the message
			String result = "Hey My Friend! " + theName;

			// d) Set message on the model
			model.addAttribute("message", result);

			return "confirmation-form";
		}


}
