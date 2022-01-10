/**
 * 
 */
package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * @author Felipe Castro
 *
 */

@Component
public class FortuneService2 implements FortuneService {
	// Fortunes Array
	private String fortunes[];
	private Random randomGenerator;
	
	/**
	 * Constructor without parameters
	 */
	public FortuneService2() {
		super();
		fortunes = new String[3];
		randomGenerator = new Random(); // Instance of Random Class
		fortunes[0] = "You can do it, believe in yourself!";
		fortunes[1] = "Never give up";
		fortunes[2] = "One step at the time";
	}

	@Override
	public String getFortune() {
		return fortunes[randomGenerator.nextInt(3)];
	}

}
