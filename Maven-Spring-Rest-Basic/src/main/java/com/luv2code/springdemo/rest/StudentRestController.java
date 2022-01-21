/**
 * 
 */
package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

/**
 * @author Felipe Castro
 *
 */

@RestController
@RequestMapping("/api")
public class StudentRestController {
	// Field to save the students, at the moment hard coded, then adding DB
	private List<Student> theStudents;

	// Using @PostConstruct to load the student data ... only once!
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rosi"));
		theStudents.add(new Student("Mary", "Smith"));
	}

	// Defined endpoint for "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {
		// Define hard coded students, implementing DB stuff later
		return theStudents;
	}

	// Defined endpoint for "/students/{student_id}" return specific student
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		// Just index into the list

		// Throw exception if the ID is bigger than the list size

		if ((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found: " + studentId);
		}

		return theStudents.get(studentId);
	}

	

}
