package com.tracker.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="student_assignment")
public class StudentAssignment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="is_completed")
	private boolean completed;
	
	private Double score;
	
	@JsonBackReference(value = "student_studentAssignments")
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	@JsonBackReference(value = "assignment_studentAssignments")
	@ManyToOne
	@JoinColumn(name="assignment_id")
	private Assignment assignment;
	
	//gets and sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	

	
}
