/**
 * 
 */
package com.luv2code.springdemo;

/**
 * @author Felipe Castro
 *
 */
public class SoccerCoach implements Coach {

	// Attributes
	private FortuneService fortuneService;
	private FortuneService2 fortuneService2;
	// Add new fields
	private String emailAddress;
	private String team;

	// Create a Non-Argument Constructor
	public SoccerCoach() {
		System.out.println("SoccerCoach: Inside no-arg Constructor");
	}
	
	/**
	 * @return the fortuneService2
	 */
	public FortuneService2 getFortuneService2() {
		return fortuneService2;
	}

	/**
	 * @param fortuneService2 the fortuneService2 to set
	 */
	public void setFortuneService2(FortuneService2 fortuneService2) {
		this.fortuneService2 = fortuneService2;
	}
	
	/**
	 * @return the fortuneService
	 */
	public FortuneService getFortuneService() {
		return fortuneService;
	}

	/**
	 * @param fortuneService the fortuneService to set
	 */
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Make 30 passes with a teammate";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public String getRandomDailyFortune() {
		return fortuneService2.getFortune();
	}

}
