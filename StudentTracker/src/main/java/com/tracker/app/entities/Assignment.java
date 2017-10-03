package com.tracker.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Assignment.findAssignmentByIdWithNotes", query="SELECT a FROM Assignment a JOIN FETCH a.notes WHERE a.id =?1")
public class Assignment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="max_score")
	private String maxScore;
	
	@ManyToMany
	@JoinTable(name="assignment_note", 
		joinColumns= @JoinColumn(name="assignment_id"), 
		inverseJoinColumns= @JoinColumn(name="note_id")
	)
	private List<Note> notes;

	@ManyToMany
	@JoinTable(name="cohort_assignment", 
		joinColumns= @JoinColumn(name="assignment_id"), 
		inverseJoinColumns= @JoinColumn(name="cohort_id")
	)
	private List<Cohort> cohorts;
	
	@ManyToMany
	@JoinTable(name="student_assignment", 
		joinColumns= @JoinColumn(name="assignment_id"), 
		inverseJoinColumns= @JoinColumn(name="student_id")
	)
	private List<Student> students;
	
	@OneToMany(mappedBy="assignment")
	private List<StudentAssignment> studentAssignments;
	
	//gets and sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(String maxScore) {
		this.maxScore = maxScore;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Cohort> getCohorts() {
		return cohorts;
	}

	public void setCohorts(List<Cohort> cohorts) {
		this.cohorts = cohorts;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
