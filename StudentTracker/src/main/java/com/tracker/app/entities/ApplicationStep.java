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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="application_step")
public class ApplicationStep {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="completed_date")
	private Date completedDate;
	
	@Column(name="is_acceptable")
	private boolean isAcceptable;
	
	@JsonBackReference(value = "application_applicationSteps")
	@ManyToOne
	@JoinColumn(name="application_id")
	private Application application;
	
	@JsonManagedReference(value = "applicationTask_applicationSteps")
	@ManyToOne
	@JoinColumn(name="application_task_id")
	private ApplicationTask appTask;
	
	//gets and sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completeDate) {
		this.completedDate = completeDate;
	}

	public boolean isAcceptable() {
		return isAcceptable;
	}

	public void setAcceptable(boolean isAcceptable) {
		this.isAcceptable = isAcceptable;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public ApplicationTask getAppTask() {
		return appTask;
	}

	public void setAppTask(ApplicationTask appTask) {
		this.appTask = appTask;
	}	
}
