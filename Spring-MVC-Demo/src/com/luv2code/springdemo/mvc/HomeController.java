/**
 * 
 */
package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Felipe Castro
 *
 */

// Telling Spring that this is a controller
@Controller
public class HomeController {
	
	// Request Map to assign an url
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}

}
