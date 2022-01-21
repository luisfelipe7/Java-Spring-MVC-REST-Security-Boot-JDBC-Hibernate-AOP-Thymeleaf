/**
 * 
 */
package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Felipe Castro
 *
 */
@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}

}
