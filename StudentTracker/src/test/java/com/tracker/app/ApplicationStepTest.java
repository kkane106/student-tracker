package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.ApplicationStep;
import com.tracker.app.repo.ApplicationStepRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationStepTest {
	@Autowired
	private ApplicationStepRepository applicationStepRepo;
	private 	ApplicationStep applicationStep;

	@Before
	public void setUp() {
		applicationStep = applicationStepRepo.findOne(1);
	}
	
	@Test
	public void test_application_step_mappings() {
		assertEquals(1, applicationStep.getId());
		assertEquals("2008-01-18", applicationStep.getCompletedDate().toString());
		assertEquals(true, applicationStep.isAcceptable());
	}
	
	@Test
	public void test_applicationSetp_to_application() {
		assertEquals(1, applicationStep.getApplication().getId());
	}
	
	@Test
	public void test_applicationSetp_to_applicationTask() {
		assertEquals(1, applicationStep.getAppTask().getId());

	}
}
