package com.tracker.app.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.app.entities.Application;
import com.tracker.app.services.ApplicationService;

@RestController
public class ApplicationController {

	private ApplicationService appService;
	
	public ApplicationController (ApplicationService appService) {
		this.appService = appService;
	}
	
	@GetMapping(path = "/applications")
	public Collection<Application> getApplications() {
		return appService.getApplications();
	}
}
