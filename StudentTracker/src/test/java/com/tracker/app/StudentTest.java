package com.tracker.app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.Application;
import com.tracker.app.entities.ApplicationStep;
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
	
	@Test
	public void test_student_to_user() {
		assertEquals(1, student.getUser().getId());
	}
	
	@Test
	public void test_student_to_address() {
		assertEquals("123 Test Street", student.getAddress().getStreet());
	}
	
	@Test
	public void test_student_to_image() {
		assertEquals("https://upload.wikimedia.org/wikipedia/commons/7/7c/Profile_avatar_placeholder_large.png", student.getImage().getUrl());
	}
	
	@Test
	public void test_all_students_with_applications() {
		List<Student> students = new ArrayList<>(); 				
		studentRepo.findByIdNotNull().forEach(students::add);
		List<Application> apps = new ArrayList<Application>(students.get(0).getApplications());
		List<ApplicationStep> steps = new ArrayList<ApplicationStep>(apps.get(0).getApplicationSteps());
		assertEquals("Resume", steps.get(0).getAppTask().getName());
	}
}