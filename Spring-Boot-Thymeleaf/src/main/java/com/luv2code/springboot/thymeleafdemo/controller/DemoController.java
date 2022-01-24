/**
 * 
 */
package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Felipe Castro
 *
 */

@Controller
public class DemoController {
	
	// Create a mapping for "/hello"
	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		theModel.addAttribute("theDate", new java.util.Date());
		
		// We have Thymeleaf dependency in Maven POM, so Spring Boot will auto-configure to use Thymeleaf
		// And it will search the template called helloworld.html on the package called "/src/main/resources/templates/helloworld.html"
		return "helloworld";
	}

}
