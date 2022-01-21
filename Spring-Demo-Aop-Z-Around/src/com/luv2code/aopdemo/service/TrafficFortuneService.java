/**
 * 
 */
package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

/**
 * @author Felipe Castro
 *
 */

@Component
public class TrafficFortuneService {

	public String getFortune() {
		// Simulate a Delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Return a Fortune
		return "Expected heavy traffic this morning";
	}

}
