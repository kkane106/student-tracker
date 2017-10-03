package com.tracker.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.app.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	public Employee findEmployeeByIdWithNotes(int id);
}
