package com.tracker.app;

import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void test_application_mappings() {
		Application application = applicationRepo.findOne(1);
		assertEquals(1, application.getId());
		assertEquals("2017-12-04", application.getCreateDate().toString());
		assertEquals(true, application.isActive());
	}
}
