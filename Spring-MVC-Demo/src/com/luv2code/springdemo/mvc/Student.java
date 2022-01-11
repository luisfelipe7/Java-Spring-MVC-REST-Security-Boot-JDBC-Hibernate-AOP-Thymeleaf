/**
 * 
 */
package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author Felipe Castro
 *
 */
public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private String language;
	private String favoritePLanguage;
	private String[] operatingSystems; //Getters and Setters
	/* Defining a list of countries*/
	private LinkedHashMap<String,String> countryOptions;
	
	public Student() {
		//Constructor without parameters
		
		// Populate Country options: used ISO Country Code
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("CR", "Costa Rica");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("US", "United States");
	
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the countryOptions
	 */
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	/**
	 * @param countryOptions the countryOptions to set
	 */
	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the favoritePLanguage
	 */
	public String getFavoritePLanguage() {
		return favoritePLanguage;
	}

	/**
	 * @param favoritePLanguage the favoritePLanguage to set
	 */
	public void setFavoritePLanguage(String favoritePLanguage) {
		this.favoritePLanguage = favoritePLanguage;
	}

	/**
	 * @return the operatingSystems
	 */
	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	/**
	 * @param operatingSystems the operatingSystems to set
	 */
	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	
	
	
	
}
