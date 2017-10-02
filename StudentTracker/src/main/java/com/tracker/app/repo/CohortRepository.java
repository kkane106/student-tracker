package com.tracker.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.app.entities.Cohort;

public interface CohortRepository extends CrudRepository<Cohort, Integer>{
	public Cohort findCohortByIdWithApplications(int id);
}
