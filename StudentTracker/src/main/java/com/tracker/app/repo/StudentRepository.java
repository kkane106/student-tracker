package com.tracker.app.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.tracker.app.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	public Student findStudentByIdWithApplications(int id);

	@EntityGraph(value = "Student.applicationsWithSteps")
	public Collection<Student> findByIdNotNull();
	
}