package com.tracker.app.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.app.entities.Student;
import com.tracker.app.repo.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;
	
	/**
	 * Returns collection of all <code>Student</code> objects
	 * Uses a <code>@NameEntityGraph</code> in <code>Student</code> Entity
	 * with name <code>Student.applicationsWithSteps</code> to query the 
	 * objects with all the data they need to be displayed in the student board
	 * @return
	 */
	public Collection<Student> findAllStudentsWithApplicationsAndSteps() {
		return studentRepo.findByIdNotNull();
	}
}
