package com.tracker.app.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.app.entities.Student;
import com.tracker.app.services.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping(path = "/students")
	public Collection<Student> getStudentsForStudentBoard() {
		return studentService.findAllStudentsWithApplicationsAndSteps();
	}
	
}
