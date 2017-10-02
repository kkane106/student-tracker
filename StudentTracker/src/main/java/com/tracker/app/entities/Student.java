package com.tracker.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String fname;
	
	private String lname;
	
	@Column(name="is_va")
	private boolean isVa;
	
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
	

}
