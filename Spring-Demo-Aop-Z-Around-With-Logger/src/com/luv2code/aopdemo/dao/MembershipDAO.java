/**
 * 
 */
package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

/**
 * @author Felipe Castro
 *
 */

@Component
public class MembershipDAO {
	
	public boolean addSillyMember() {
		System.out.println(getClass()+ ": DOING STUFF: ADDING A SILLY MEMBER");
		
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass()+" I am going to sleep");
	}
}
