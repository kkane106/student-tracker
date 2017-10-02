package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.StudentAssignment;
import com.tracker.app.repo.StudentAssignmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentAssignmentTest {
	@Autowired
	private StudentAssignmentRepository studentAssignmentRepo;
	
	@Test
	public void test_student_assignment_mappings() {
		StudentAssignment studentAssignment = studentAssignmentRepo.findOne(1);
		assertEquals(1, studentAssignment.getId());
		assertEquals(1.0, studentAssignment.getScore(), .1);
		assertEquals(true, studentAssignment.isCompleted());
	}
}
