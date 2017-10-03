package com.tracker.app.entities;

import java.sql.Date;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NamedQuery(name="Cohort.findCohortByIdWithApplications", query="SELECT c FROM Cohort c JOIN FETCH c.applications WHERE c.id =?1")
public class Cohort {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String nickname;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	private int capacity;
	
	@JsonManagedReference(value = "cohort_applications")
	@OneToMany(mappedBy="cohort")
	private Set<Application> applications;

	@JsonIgnore
	@ManyToMany(mappedBy="cohorts")
	private Set<Assignment> assignments;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="cohort_student", 
		joinColumns= @JoinColumn(name="cohort_id"), 
		inverseJoinColumns= @JoinColumn(name="student_id")
	)
	private Set<Student> students;
	
	@JsonManagedReference(value = "cohort_cohortStudents")
	@OneToMany(mappedBy="cohort")
	private Set<CohortStudent> cohortStudents;
	
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<CohortStudent> getCohortStudents() {
		return cohortStudents;
	}

	public void setCohortStudents(Set<CohortStudent> cohortStudents) {
		this.cohortStudents = cohortStudents;
	}
	
}
