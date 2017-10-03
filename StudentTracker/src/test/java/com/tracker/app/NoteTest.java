package com.tracker.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
	private Note note;

	@Before
	public void setUp() {
		note = noteRepo.findOne(1);
	}
	
	@Test
	public void test_note_mappings() {
		assertEquals(1, note.getId());
		assertEquals("Test Topic", note.getTopic());
		assertEquals("Test Content...", note.getContent());
	}
	
	@Test
	public void test_note_to_employee() {
		assertEquals(1, note.getEmployee().getId());
	}
	
	@Test
	public void test_note_to_assignment() {
		assertEquals(1, noteRepo.findNoteByIdWithAssignments(1).getAssignments().size());
	}
	
	
}
