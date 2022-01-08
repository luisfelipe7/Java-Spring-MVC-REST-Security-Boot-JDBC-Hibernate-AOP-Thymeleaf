/**
 * 
 */
package com.luv2code.springdemo;

/**
 * @author Felipe Castro
 *
 */
public class MyApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create the Objects, using Interface = Implementation
		Coach firstCoach= new BaseballCoach();
		Coach secondCoach = new TrackCoach();
		
		// Use the Objects
		System.out.println(firstCoach.getDailyWorkout());
		System.out.println(secondCoach.getDailyWorkout());

	}

}
