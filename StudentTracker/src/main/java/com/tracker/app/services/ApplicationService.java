package com.tracker.app.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.app.entities.Application;
import com.tracker.app.repo.ApplicationRepository;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationRepository appRepo;
	
	public Collection<Application> getApplications() {
		List<Application> applications = new ArrayList<>();
		appRepo.findAll().forEach(applications::add);
		return applications;
	}
}
