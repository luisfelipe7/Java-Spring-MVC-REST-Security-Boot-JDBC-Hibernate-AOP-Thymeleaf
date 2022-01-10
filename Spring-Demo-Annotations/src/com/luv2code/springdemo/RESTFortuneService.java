/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

/**
 * @author Felipe Castro
 *
 */

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Have a good REST day!";
	}

}
