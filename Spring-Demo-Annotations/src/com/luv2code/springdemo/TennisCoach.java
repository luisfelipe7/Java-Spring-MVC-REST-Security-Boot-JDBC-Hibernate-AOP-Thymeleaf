/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Felipe Castro
 *
 */

/* Spring will automatically register this bean using the id "tennisCoach" */
// If I put @Component the default bean id will be the class name lower case then upper case, example: tennisCoach
@Component("tennisCoach")
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	/**
	 * @param fortuneService
	 */
	// Spring will automatically inject the component
	@Autowired
	public TennisCoach(@Qualifier("databaseFortuneService") FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your bachand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
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
	
}