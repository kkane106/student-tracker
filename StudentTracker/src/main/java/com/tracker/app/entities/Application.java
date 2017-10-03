package com.tracker.app.entities;

import java.sql.Date;
import java.util.List;

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
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="cohort_id")
	private Cohort cohort;
	
	@ManyToMany
	@JoinTable(name="application_step", 
		joinColumns= @JoinColumn(name="application_id"), 
		inverseJoinColumns= @JoinColumn(name="application_task_id")
	)
	private List<ApplicationTask> applicationTasks;

	@OneToMany(mappedBy="application")
	private List<ApplicationStep> applicationSteps;

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
	public List<ApplicationTask> getApplicationTasks() {
		return applicationTasks;
	}

	public void setApplicationTasks(List<ApplicationTask> applicationTasks) {
		this.applicationTasks = applicationTasks;
	}

	public List<ApplicationStep> getApplicationSteps() {
		return applicationSteps;
	}

	public void setApplicationSteps(List<ApplicationStep> applicationSteps) {
		this.applicationSteps = applicationSteps;
	}


	
}
