package com.tracker.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="application_task")
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
	
	
}
