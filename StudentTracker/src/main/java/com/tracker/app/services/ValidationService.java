package com.tracker.app.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
	private final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	/**
	 * Password expression. Password must be between 4 and 8 digits long and include at least one numeric digit.
	 */
	private final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^(?=.*\\d).{4,8}$");
	
	private final Pattern VALID_USERNAME_REGEX = Pattern.compile("^[A-Z0-9]{4,15}",Pattern.CASE_INSENSITIVE);

	public boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
	
	public boolean validatePassword(String passwordStr) {
		Matcher matcher = VALID_PASSWORD_REGEX.matcher(passwordStr);
		return matcher.find();
	}
	
	public boolean validateUsername(String usernameStr) {
		Matcher matcher = VALID_USERNAME_REGEX.matcher(usernameStr);
		return matcher.find();
	}
	
}
