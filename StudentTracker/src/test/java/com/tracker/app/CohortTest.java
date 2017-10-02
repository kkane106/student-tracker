package com.tracker.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.Cohort;
import com.tracker.app.repo.CohortRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CohortTest {
	@Autowired
	private CohortRepository cohortRepo;
	
	@Test
	public void test_address_mappings() {
		Cohort cohort = cohortRepo.findOne(1);

	}
}
