package com.tracker.app;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StudentTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentTrackerApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder injectPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PropertyPlaceholderConfigurer injectPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer config = new PropertyPlaceholderConfigurer();
		config.setLocation(new ClassPathResource("jwt.properties"));
		
		return config;
	}
	
}
