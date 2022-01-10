/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Felipe Castro
 *
 */
public class SwimCoach implements Coach {
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	
	/**
	 * @param fortuneService
	 */
	
	// Constructor to use parameter injection
	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters a a warm up";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void displayInformation() {
		System.out.println("Email "+this.email+" - Team: "+this.team);
	}

}
