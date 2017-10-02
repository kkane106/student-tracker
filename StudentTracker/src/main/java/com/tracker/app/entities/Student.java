package com.tracker.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Student.findStudentByIdWithApplications", query="SELECT s FROM Student s JOIN FETCH s.applications WHERE s.id =?1")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String fname;
	
	private String lname;
	
	@Column(name="is_va")
	private boolean isVa;
	
	@OneToMany(mappedBy="student")
	private List<Application> applications;
	
//	private User user;
//	private Address address;
//	private Image image;

	//gets and sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public boolean isVa() {
		return isVa;
	}

	public void setVa(boolean isVa) {
		this.isVa = isVa;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	

}
