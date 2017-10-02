package com.tracker.app;

import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void test_application_step_mappings() {
		ApplicationStep applicationStep = applicationStepRepo.findOne(1);
		assertEquals(1, applicationStep.getId());
		assertEquals("", applicationStep.getCompleteDate());
		assertEquals(true, applicationStep.isAcceptable());
	}
}
