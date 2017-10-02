package com.tracker.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.app.entities.ApplicationTask;

public interface ApplicationTaskRepository extends CrudRepository<ApplicationTask, Integer>{

}
