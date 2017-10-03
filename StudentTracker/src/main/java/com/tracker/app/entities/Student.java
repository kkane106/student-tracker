package com.tracker.app.entities;

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
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="Student.findStudentByIdWithApplications",
			query="SELECT s FROM Student s JOIN FETCH s.applications WHERE s.id =?1")
@NamedEntityGraph(name = "Student.applicationsWithSteps",
					attributeNodes = @NamedAttributeNode(value = "applications",
														subgraph = "steps"),
					subgraphs = @NamedSubgraph(name = "steps",
												attributeNodes = @NamedAttributeNode("applicationSteps")))
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String fname;

	private String lname;

	@Column(name="is_va")
	private boolean isVa;

	@OneToMany(mappedBy="student")
	private Set<Application> applications;

	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;

	@OneToOne
	@JoinColumn(name="image_id")
	private Image image;

	@ManyToMany(mappedBy="students")
	private Set<Cohort> cohorts;

	@OneToMany(mappedBy="student")
	private Set<CohortStudent> cohortStudents;

	@ManyToMany(mappedBy="students")
	private Set<Assignment> assignments;

	@OneToMany(mappedBy="student")
	private Set<StudentAssignment> studentAssignments;

	@ManyToMany
	@JoinTable(name="student_contact",
		joinColumns= @JoinColumn(name="student_id"),
		inverseJoinColumns= @JoinColumn(name="contact_id")
	)
	private Set<Contact> contacts;

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

	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Set<Cohort> getCohorts() {
		return cohorts;
	}

	public void setCohorts(Set<Cohort> cohorts) {
		this.cohorts = cohorts;
	}

	public Set<CohortStudent> getCohortStudents() {
		return cohortStudents;
	}

	public void setCohortStudents(Set<CohortStudent> cohortStudents) {
		this.cohortStudents = cohortStudents;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	public Set<StudentAssignment> getStudentAssignments() {
		return studentAssignments;
	}

	public void setStudentAssignments(Set<StudentAssignment> studentAssignments) {
		this.studentAssignments = studentAssignments;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}


}
