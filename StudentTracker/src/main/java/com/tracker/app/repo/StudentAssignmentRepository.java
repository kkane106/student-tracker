package com.tracker.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.app.entities.StudentAssignment;

public interface StudentAssignmentRepository extends CrudRepository<StudentAssignment, Integer>{

}
