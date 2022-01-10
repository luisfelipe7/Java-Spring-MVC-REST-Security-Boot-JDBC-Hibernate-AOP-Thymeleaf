/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Felipe Castro
 *
 */

@Configuration
// @ComponentScan("com.luv2code.springdemo") -> This will cause to just use the manually defined beans here (Sad Fortune Service and Coach)
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// Define bean for our sad fortune service
	// The name of the method will be the assigned ID to the bean
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// Define bean for our swim coach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
