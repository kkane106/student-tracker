package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
	private Cohort cohort;
	
	@Before
	public void setUp() {
		cohort = cohortRepo.findOne(1);
	}
	
	@Test
	public void test_cohort_mappings() {
		assertEquals(1, cohort.getId());
		assertEquals("SDTEST", cohort.getName());
		assertEquals("SD TEST", cohort.getNickname());
		assertEquals("2008-11-11", cohort.getStartDate().toString());
		assertEquals("2008-12-12", cohort.getEndDate().toString());
		assertEquals(23, cohort.getCapacity());
	}
	
	@Test
	public void test_cohort_to_applications() {
		assertEquals(1, cohortRepo.findCohortByIdWithApplications(1).getApplications().size());
	}
}
