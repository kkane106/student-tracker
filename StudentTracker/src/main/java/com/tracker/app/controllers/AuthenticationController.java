package com.tracker.app.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.app.entities.User;
import com.tracker.app.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	private AuthenticationService authService;
	
	public AuthenticationController(AuthenticationService authService) {
		this.authService = authService;
	}
	
	@PostMapping(path = "/register")
	public void register(@RequestBody User user, HttpServletResponse res) {
		User registeredUser = authService.register(user);
		System.out.println(registeredUser);
		
		if (registeredUser == null) {
			res.setStatus(400);
		}
	}
}
