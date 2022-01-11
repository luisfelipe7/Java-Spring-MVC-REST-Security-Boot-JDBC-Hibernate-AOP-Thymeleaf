/**
 * 
 */
package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Felipe Castro
 *
 */
@Controller
@RequestMapping("/student")
public class StudentController {
	
	// Loading the languages options from the files

    @Value("#{languagesOptions}") 
    private Map<String, String> languagesOptions;

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		// Create a new student object
		Student theStudent = new Student();

		// Add student object to the model
		theModel.addAttribute("student", theStudent);
		
		// Add the languages options to the model
		theModel.addAttribute("languagesOptions",languagesOptions);

		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent){
		
		// Log the input data
		System.out.println("theStudent: "+theStudent.getFirstName()+" "+theStudent.getLastName());
		return "student-confirmation";
	}

}
