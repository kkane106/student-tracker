package com.tracker.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.app.entities.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer>{
	public Assignment findAssignmentByIdWithNotes(int id);
}
