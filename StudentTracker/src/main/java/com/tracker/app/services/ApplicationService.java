package com.tracker.app.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tracker.app.entities.Application;
import com.tracker.app.repo.ApplicationRepository;

@Service
public class ApplicationService {

	private ApplicationRepository appRepo;
	
	public ApplicationService(ApplicationRepository appRepo) {
		this.appRepo = appRepo;
	}
	
	public Collection<Application> getApplications() {
		List<Application> applications = new ArrayList<>();
		appRepo.findAll().forEach(applications::add);
		return applications;
	}
}
