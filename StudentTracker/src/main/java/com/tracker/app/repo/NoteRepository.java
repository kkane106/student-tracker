package com.tracker.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.app.entities.Note;

public interface NoteRepository extends CrudRepository<Note, Integer>{

}
