/**
 * 
 */
package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 * @author Felipe Castro
 *
 */

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Add our users for in memory authentication

		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("John").password("test123").roles("EMPLOYEE"))
				.withUser(users.username("Mary").password("test123").roles("MANAGER", "EMPLOYEE"))
				.withUser(users.username("SUSAN").password("test123").roles("ADMIN", "EMPLOYEE"));

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/css/**").permitAll().
		antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and().formLogin()
				.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll().and().logout()
				.permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");

	}

}
