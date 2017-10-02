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
	
	
}
