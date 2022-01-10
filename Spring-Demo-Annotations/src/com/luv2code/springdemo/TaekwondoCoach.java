/**
 * 
 */
package com.luv2code.springdemo;

/**
 * @author Felipe Castro
 *
 */
public class TaekwondoCoach implements Coach {
	private SpanishFortuneService spanishFortune;
	
	@Override
	public String getDailyWorkout() {
		return "Do Poomsae during 20 minutes, trying to learn it and if you already know it just for practice";
	}

	@Override
	public String getDailyFortune() {
		return spanishFortune.getFortune();
	}

	/**
	 * @param spanishFortune
	 */
	public TaekwondoCoach(SpanishFortuneService spanishFortune) {
		super();
		this.spanishFortune = spanishFortune;
	}
	
	

}
