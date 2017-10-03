package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
	private 	ApplicationTask applicationTask;

	@Before
	public void setUp() {
		applicationTask = applicationTaskRepo.findOne(1);
	}
	
	@Test
	public void test_application_task_mappings() {
		assertEquals(1, applicationTask.getId());
		assertEquals("Resume", applicationTask.getName());
		assertEquals("Resume", applicationTask.getDescription());
		assertEquals(true, applicationTask.isActive());
		assertEquals(1, applicationTask.getApplicationTaskOrder());
	}
	
	@Test
	public void test_applicationTask_to_applications() {
		assertEquals(1, applicationTaskRepo.findApplicationTaskByIdWithApps(1).getApplications().size());
	}
}
