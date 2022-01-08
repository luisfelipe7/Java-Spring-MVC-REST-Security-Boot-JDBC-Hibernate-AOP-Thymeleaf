/**
 * 
 */
package com.luv2code.springdemo;

/**
 * @author Felipe Castro
 *
 */
public class SwimmingCoach implements Coach {
	// Defining a private field for the dependency
	private FortuneService fortuneService;

	// Defining a constructor with my field for dependency injection
	public SwimmingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	// Default Constructor
	public SwimmingCoach() {
		super();
	}
	
	// Init Method for my Bean
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: Inside method doMyStartupStuff");
	}
	public void doMyDestroyStuff() {
		System.out.println("TrackCoach: Inside method doMyDestroyStuff");
	}
	


	@Override
	public String getDailyWorkout() {
		return "Make 5 butterfly style pool";
	}

	@Override
	public String getDailyFortune() {
		return "S-Do It! - "+fortuneService.getFortune();
	}

}
