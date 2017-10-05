package com.tracker.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.app.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public User findByEmail(String email);

	public User findByUsername(String username);
}
