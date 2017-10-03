package com.tracker.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.Assignment;
import com.tracker.app.repo.AssignmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssignmentTest {

	@Autowired
	private AssignmentRepository assignmentRepo;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void test_assignment_mappings() {
		Assignment assignment = assignmentRepo.findOne(1);
		assertEquals(1, assignment.getId());
		assertEquals("Test Assignment", assignment.getName());
		assertEquals("2", assignment.getMaxScore());
	}
	
}
