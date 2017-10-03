package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
	private 	CohortStudent cohortStudent;

	@Before
	public void setUp() {
		cohortStudent = cohortStudentRepo.findOne(1);
	}
	
	@Test
	public void test_cohort_student_mappings() {
		assertEquals(1, cohortStudent.getId());
		assertEquals("2008-01-18", cohortStudent.getAcceptedDate().toString());
	}
	
	@Test
	public void test_cohort_student_to_student() {
		assertEquals(1, cohortStudent.getStudent().getId());
	}
	
	@Test
	public void test_cohortStudent_to_cohort() {
		assertEquals(1, cohortStudent.getCohort().getId());
	}
}
