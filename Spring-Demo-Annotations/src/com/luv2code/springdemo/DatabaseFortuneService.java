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
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Have a good database fortune";
	}

}
