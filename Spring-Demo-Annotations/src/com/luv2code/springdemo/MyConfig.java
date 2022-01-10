/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Felipe Castro
 *
 */

// File Created to save my configuration

@Configuration
public class MyConfig {
	
	// Defining the bean for my Spanish Fortune Service
	@Bean
	public SpanishFortuneService spanishFortuneService() {
		return new SpanishFortuneService();
	}
	
	// Defining the bean for my Taekwondo Coach
	@Bean 
	public TaekwondoCoach taekwondoCoach() {
		return new TaekwondoCoach(spanishFortuneService());
	}

}
