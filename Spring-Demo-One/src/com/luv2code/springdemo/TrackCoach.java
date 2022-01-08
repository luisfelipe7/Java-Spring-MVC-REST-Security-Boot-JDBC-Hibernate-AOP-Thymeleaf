/**
 * 
 */
package com.luv2code.springdemo;

/**
 * @author Felipe Castro
 *
 */
public class TrackCoach implements Coach {
	// Defining a private field for the dependency
	private FortuneService fortuneService;

	// Defining a constructor with my field for dependency injection
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	// Default Constructor
	public TrackCoach() {
		super();
	}
	

	// Destroy Method for my Bean

	@Override
	public String getDailyWorkout() {
		// Returning the Track Workout
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "T-Do It! - "+fortuneService.getFortune();
	}

}
