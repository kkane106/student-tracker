package com.tracker.app.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="cohort_student")
public class CohortStudent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="accepted_date")
	private Date acceptedDate;
	
	@JsonBackReference(value = "student_cohortStudents")
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	@JsonBackReference(value = "cohort_cohortStudents")
	@ManyToOne
	@JoinColumn(name="cohort_id")
	private Cohort cohort;
	
	//gets and sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}

}
