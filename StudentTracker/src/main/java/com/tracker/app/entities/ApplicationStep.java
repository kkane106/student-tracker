package com.tracker.app.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="application_step")
public class ApplicationStep {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="complete_date")
	private Date completeDate;
	
	@Column(name="is_acceptable")
	private boolean isAcceptable;
	
//	private Application application;
//	private ApplicationTast appTask;
	
}
