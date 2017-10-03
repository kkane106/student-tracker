package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
	private 	StudentAssignment studentAssignment;
	
	@Before
	public void setUp() {
		studentAssignment = studentAssignmentRepo.findOne(1);
	}
	
	@Test
	public void test_student_assignment_mappings() {
		assertEquals(1, studentAssignment.getId());
		assertEquals(1.0, studentAssignment.getScore(), .1);
		assertEquals(true, studentAssignment.isCompleted());
	}
	
	@Test
	public void test_studentAssignment_to_student() {
		assertEquals(1, studentAssignment.getStudent().getId());
	}
	
	@Test
	public void test_studentAssignment_to_assigment() {
		assertEquals(1, studentAssignment.getAssignment().getId());
	}
}
