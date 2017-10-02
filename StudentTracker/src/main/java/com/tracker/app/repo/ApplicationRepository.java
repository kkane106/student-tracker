package com.tracker.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.app.entities.Application;

public interface ApplicationRepository extends CrudRepository<Application, Integer>{

}
