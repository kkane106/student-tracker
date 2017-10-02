package com.tracker.app.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Application {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
//	private Student student;
//	private Cohort cohort;
}
