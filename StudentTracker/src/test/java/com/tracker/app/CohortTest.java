package com.tracker.app;

import static org.junit.Assert.assertEquals;

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
	public void test_cohort_mappings() {
		Cohort cohort = cohortRepo.findOne(1);
		assertEquals(1, cohort.getId());
		assertEquals("SDTEST", cohort.getName());
		assertEquals("SD TEST", cohort.getNickname());
		assertEquals("2008-11-11", cohort.getStartDate().toString());
		assertEquals("2008-12-12", cohort.getEndDate().toString());
		assertEquals(23, cohort.getCapacity());
	}
}
