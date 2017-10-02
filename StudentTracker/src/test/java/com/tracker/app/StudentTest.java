package com.tracker.app;

import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void test_student_mappings() {
		Student student = studentRepo.findOne(1);
		assertEquals(1, student.getId());
		assertEquals("Test", student.getFname());
		assertEquals("Test", student.getLname());
		assertEquals(true, student.isVa());
	}
}