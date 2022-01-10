/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.*;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * @author Felipe Castro
 *
 */
@Component
// @Scope("prototype") - Using Singleton Scope since this is commented
public class BoxingCoach implements Coach {

	/*
	 * Spring will set the field automatically behind the scenes, like the set
	 * method
	 */
	@Autowired
	@Qualifier("fileService")
	private FortuneService fortuneService;
	private String luckyMessage;

	//@Value("${foo.professionalName}")
	private String professionalName;
	//@Value("#{foo.numberOfTitles}")
	private String numberOfTittles;

	/**
	 * @param fortuneService
	 */
	// Spring will automatically inject the component

	/*
	 * Commenting the constructor injection
	 * 
	 * @Autowired public BoxingCoach(FortuneService fortuneService) { super();
	 * this.fortuneService = fortuneService; }
	 */

	// Creating a constructor without parameters
	public BoxingCoach() {
		System.out.println(">> BoxingCoach: Inside default constructor");
	}

	// Adding the Init Method and due to the annotation called PostConstruct this
	// method will be executed after the constructor
	@PostConstruct
	public void initMethod() {
		System.out.println(">> BoxingCoach: Executing the init method");
	}

	// Adding the Destroy Method and due to the annotation called PreDestroy this
	// method will be executed before destroying the object/bean
	@PreDestroy
	public void destroyMethod() {
		System.out.println(">> BoxingCoach: Executing the destroy method");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice during 10 minutes kicking the boxing bag";
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
	// Setting an automatic setter injection
	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * System.out.println(">> BoxingCoach: Inside setFortuneService() method");
	 * this.fortuneService = fortuneService; luckyMessage=
	 * fortuneService.getFortune(); }
	 */

	// I can use autowired to inject any method
	@Autowired
	public void injectedMethod() {
		System.out.println("Calling injectedMethod via the autowired");
		luckyMessage = "I am the new Lucky Message";
	}

	public String information() {
		String information = this.professionalName + " - Number of Tittles: " + this.numberOfTittles;
		return information;
	}

}
