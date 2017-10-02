package com.tracker.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.ApplicationTask;
import com.tracker.app.repo.ApplicationTaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTaskTest {
	@Autowired
	private ApplicationTaskRepository applicationTaskRepo;
	
	@Test
	public void test_application_task_mappings() {
		ApplicationTask applicationTask = applicationTaskRepo.findOne(1);
	}
}
