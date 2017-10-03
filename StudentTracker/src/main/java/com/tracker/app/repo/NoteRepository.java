package com.tracker.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.app.entities.Note;

public interface NoteRepository extends CrudRepository<Note, Integer>{
	public Note findNoteByIdWithAssignments(int id);
}
