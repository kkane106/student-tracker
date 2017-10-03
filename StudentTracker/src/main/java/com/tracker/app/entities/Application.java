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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NamedQuery(name="Application.findApplicationtByIdWithTasks", query="SELECT a FROM Application a JOIN FETCH a.applicationTasks WHERE a.id =?1")
public class Application {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@JsonBackReference(value = "student_applications")
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	@JsonBackReference(value = "cohort_applications")
	@ManyToOne
	@JoinColumn(name="cohort_id")
	private Cohort cohort;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="application_step", 
		joinColumns= @JoinColumn(name="application_id"), 
		inverseJoinColumns= @JoinColumn(name="application_task_id")
	)
	private Set<ApplicationTask> applicationTasks;

	@JsonManagedReference(value = "application_applicationSteps")
	@OneToMany(mappedBy="application")
	private Set<ApplicationStep> applicationSteps;

	//gets and sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	public Set<ApplicationTask> getApplicationTasks() {
		return applicationTasks;
	}

	public void setApplicationTasks(Set<ApplicationTask> applicationTasks) {
		this.applicationTasks = applicationTasks;
	}

	public Set<ApplicationStep> getApplicationSteps() {
		return applicationSteps;
	}

	public void setApplicationSteps(Set<ApplicationStep> applicationSteps) {
		this.applicationSteps = applicationSteps;
	}


	
}
