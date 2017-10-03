package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.Employee;
import com.tracker.app.repo.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {
	@Autowired
	private EmployeeRepository employeeRepo;
	private Employee employee; 
	
	@Before
	public void setUp() {
		employee = employeeRepo.findOne(1);
	}

	@Test
	public void test_employee_mappings() {
		assertEquals(1, employee.getId());
		assertEquals("Test", employee.getFname());
		assertEquals("Employee", employee.getLname());
	}
	
	@Test
	public void test_employee_to_user() {
		assertEquals(1, employee.getUser().getId());
	}
	
	@Test
	public void test_employee_to_notes() {
		assertEquals(1, employeeRepo.findEmployeeByIdWithNotes(1).getNotes().size());
	}
}
