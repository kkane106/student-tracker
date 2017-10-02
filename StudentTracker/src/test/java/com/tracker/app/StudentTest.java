package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.Student;
import com.tracker.app.repo.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
	@Autowired
	private StudentRepository studentRepo;
	private Student student;
	
	@Before
	public void setUp() {
		student = studentRepo.findOne(1);
	}
	
	@Test
	public void test_student_mappings() {
		assertEquals(1, student.getId());
		assertEquals("Test", student.getFname());
		assertEquals("Test", student.getLname());
		assertEquals(true, student.isVa());
	}
	
	@Test
	public void test_student_to_applications() {
		assertEquals(1, studentRepo.findStudentByIdWithApplications(1).getApplications().size());
	}
}