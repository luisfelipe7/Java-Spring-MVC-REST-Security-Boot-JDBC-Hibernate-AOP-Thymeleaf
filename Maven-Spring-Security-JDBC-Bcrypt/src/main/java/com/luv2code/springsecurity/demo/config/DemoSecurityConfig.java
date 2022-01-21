/**
 * 
 */
package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	// Add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Add our users for in memory authentication

		// Database users, using JDBC Authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
		/*
		 * HARD CODED USERS
		 *
		 * 
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * 
		 * auth.inMemoryAuthentication().withUser(users.username("John").password(
		 * "test123").roles("EMPLOYEE"))
		 * .withUser(users.username("Mary").password("test123").roles("MANAGER",
		 * "EMPLOYEE"))
		 * .withUser(users.username("SUSAN").password("test123").roles("ADMIN",
		 * "EMPLOYEE"));
		 */
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/css/**").permitAll().antMatchers("/").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER").antMatchers("/systems/**").hasRole("ADMIN").and()
				.formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll().and()
				.logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");

	}

}
