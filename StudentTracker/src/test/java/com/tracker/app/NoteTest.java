package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.app.entities.Note;
import com.tracker.app.repo.NoteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteTest {
	@Autowired
	private NoteRepository noteRepo;
	
	@Test
	public void test_employee_mappings() {
		Note note = noteRepo.findOne(1);
		assertEquals(1, note.getId());
		assertEquals("Test Topic", note.getTopic());
		assertEquals("Test Content...", note.getContent());
	}
}
