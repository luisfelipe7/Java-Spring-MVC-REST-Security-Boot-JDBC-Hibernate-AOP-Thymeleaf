/**
 * 
 */
package com.luv2code.springdemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

/**
 * @author Felipe Castro
 *
 */

@Component("fileService")
public class FileFortuneService implements FortuneService {
	// Fortunes Array
	private List<String> fortunes;

	// For file loading
	private Random randomGenerator;
	private FileInputStream fileIs;
	private Scanner sc;

	/**
	 * 
	 */
	public FileFortuneService() {
		super();
		System.out.println(">> FileFortuneService: Inside default constructor");
	}

	// Adding the Init Method and due to the annotation called PostConstruct this
	// method will be executed after the constructor
	@PostConstruct
	public void initMethod() {
		System.out.println(">> FileFortuneService: Calling the init method");
		randomGenerator = new Random(); // Instance of Random Class

		// Reading the file and inserting into the array
		try {
			fileIs = new FileInputStream("src/fileToLoad.txt");
			sc = new Scanner(fileIs); // File to be scanned

			// Initializing the array
			fortunes = new ArrayList<>();

			// Now Reading the file line by line
			while (sc.hasNextLine()) {
				fortunes.add(sc.nextLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Adding the Destroy Method and due to the annotation called PreDestroy this
	// method will be executed before destroying the object/bean
	@PreDestroy
	public void destroyMethod() {
		System.out.println(">> FileFortuneService: Calling the destroy method");
		sc.close();
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return fortunes.get(randomGenerator.nextInt(fortunes.size()));
	}

}
