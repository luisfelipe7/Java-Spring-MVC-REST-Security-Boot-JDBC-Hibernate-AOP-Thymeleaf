/**
 * 
 */
package com.luv2code.springdemo;

/**
 * @author Felipe Castro
 *
 */
public class CricketCoach implements Coach {
	
	// Attributes
	private FortuneService fortuneService;
	// Add new fields
	private String emailAddress;
	private String team;

	// Create a Non-Argument Constructor
	public CricketCoach() {
		System.out.println("CricketCoach: Inside no-arg Constructor");
	}
	
	// Defined getters and setters	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: Inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: Inside setter method - setTeam");
		this.team = team;
	}


	public FortuneService getFortuneService() {
		return fortuneService;
	}

	// Setter required for the setter injection
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: Inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
