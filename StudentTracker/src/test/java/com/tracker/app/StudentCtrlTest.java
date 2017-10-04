package com.tracker.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tracker.app.controllers.StudentController;
import com.tracker.app.services.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentCtrlTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private StudentService studentService;

	@Test
	public void test_getStudentsForStudentBoard() throws Exception {
		this.mvc.perform(
				get("/students")
				.accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk());
	}
}
