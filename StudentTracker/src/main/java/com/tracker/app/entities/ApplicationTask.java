package com.tracker.app.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="application_task")
@NamedQuery(name="ApplicationTask.findApplicationTaskByIdWithApps", query="SELECT a FROM ApplicationTask a JOIN FETCH a.applications WHERE a.id =?1")
public class ApplicationTask {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="application_task_order")
	private int applicationTaskOrder;
	
	@ManyToMany(mappedBy="applicationTasks")
	private Set<Application> applications;
	
	@OneToMany(mappedBy="appTask")
	private Set<ApplicationStep> applicationSteps;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getApplicationTaskOrder() {
		return applicationTaskOrder;
	}

	public void setApplicationTaskOrder(int applicationTaskOrder) {
		this.applicationTaskOrder = applicationTaskOrder;
	}
	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}

	public Set<ApplicationStep> getApplicationSteps() {
		return applicationSteps;
	}

	public void setApplicationSteps(Set<ApplicationStep> applicationSteps) {
		this.applicationSteps = applicationSteps;
	}
}
