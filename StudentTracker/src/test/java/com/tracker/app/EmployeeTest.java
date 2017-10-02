package com.tracker.app;

import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void test_cohort_mappings() {
		Employee employee = employeeRepo.findOne(1);
		assertEquals(1, employee.getId());
		assertEquals("Test", employee.getFname());
		assertEquals("Employee", employee.getLname());
	}
}
