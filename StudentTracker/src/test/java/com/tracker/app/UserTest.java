package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.User;
import com.tracker.app.repo.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void test_user_mappings() {
		User user = userRepo.findOne(1);
		assertEquals(1, user.getId());
		assertEquals("test@test.com", user.getEmail());
		assertEquals("test", user.getPassword());
	}
}