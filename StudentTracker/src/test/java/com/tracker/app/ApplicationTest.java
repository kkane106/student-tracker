package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.Application;
import com.tracker.app.repo.ApplicationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	@Autowired
	private ApplicationRepository applicationRepo;
	private Application application;
	
	@Before
	public void setUp() {
		application = applicationRepo.findOne(1);
	}
	
	@Test
	public void test_application_mappings() {
		assertEquals(1, application.getId());
		assertEquals("2008-01-18", application.getCreateDate().toString());
		assertEquals(true, application.isActive());
	}
	
	@Test
	public void test_application_to_student() {
		assertEquals("Test", application.getStudent().getFname());
	}
	
	@Test
	public void test_application_to_cohort() {
		assertEquals("SDTEST", application.getCohort().getName());
	}
}
