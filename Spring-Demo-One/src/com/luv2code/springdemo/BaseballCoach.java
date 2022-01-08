/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.beans.factory.DisposableBean;

/**
 * @author Felipe Castro
 *
 */
public class BaseballCoach implements Coach, DisposableBean {
	//Defining a private field for the dependency
	private FortuneService fortuneService;
	
	//Defining a constructor with my field for dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	// Default Constructor
	public BaseballCoach() {
		super();
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// Use my fortuneService to get a fortune
		return "B-Do It! - "+fortuneService.getFortune();
	}
	
	public void initObject() {
		System.out.println("Initializating the Object BaseBall");
	}

	// This is required when we are using the scope prototype, the method will be called when the object is destroyed
	@Override
	public void destroy() throws Exception {
		System.out.println("I am destroying a element with scope prototype");
	}
	
	

}
