package com.tracker.app.services;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tracker.app.entities.User;
import com.tracker.app.repo.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	private UserRepository userRepo;
	private BCryptPasswordEncoder encoder;
	private ValidationService validationService;

	public AuthenticationService(UserRepository userRepo, BCryptPasswordEncoder encoder, ValidationService validationService) {
		this.userRepo = userRepo;
		this.encoder = encoder;
		this.validationService = validationService;
	}

	public User register(User user) {
		
		if (!validationService.validateEmail(user.getEmail())) {
			return null;
		}
		if (!validationService.validatePassword(user.getPassword())) {
			return null;
		}
		if (!validationService.validateUsername(user.getUsername())) {
			return null;
		}
		user.setPassword(encoder.encode(user.getPassword()));
		user = userRepo.save(user);
		return user;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new org.springframework.security.core.userdetails.User(
						user.getUsername(), user.getPassword(), Collections.emptyList());

	}


}
