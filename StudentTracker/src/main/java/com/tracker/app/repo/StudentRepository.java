package com.tracker.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.app.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	public Student findStudentByIdWithApplications(int id);
}
