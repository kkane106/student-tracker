package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.CohortStudent;
import com.tracker.app.repo.CohortStudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CohortStudentTest {

	@Autowired
	private CohortStudentRepository cohortStudentRepo;
	
	@Test
	public void test_cohort_mappings() {
		CohortStudent cohortStudent = cohortStudentRepo.findOne(1);
		assertEquals(1, cohortStudent.getId());
		assertEquals("2008-01-18", cohortStudent.getAcceptedDate().toString());
	}
}
