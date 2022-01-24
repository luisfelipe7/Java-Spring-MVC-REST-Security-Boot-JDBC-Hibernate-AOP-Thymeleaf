/**
 * 
 */
package com.luv2code.springboot.demo.springbootbasicapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Felipe Castro
 *
 */
@RestController
public class FunRestController {

	// Expose "/" that return "Hello World"
	@GetMapping("/")
	public String welcomePage() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}

	// Expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}

	// Expose a new endpoint for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day";
	}
}
