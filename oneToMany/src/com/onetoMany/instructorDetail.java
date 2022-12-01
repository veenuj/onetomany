package com.onetoMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name="instructor")
public class instructorDetail {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Override
	public String toString() {
		return "instructorDetail [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + ", courses=" + courses + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public profileInstructor getInstructorDetail() {
		return instructorDetail;
	}



	public void setInstructorDetail(profileInstructor instructorDetail) {
		this.instructorDetail = instructorDetail;
	}



	public instructorDetail(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_profile_id")
	private profileInstructor instructorDetail;
	
	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	@OneToMany(mappedBy = "instructor",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> courses;
	
	public void add(Course tempCourse) {
		if(courses == null) {
			courses = new ArrayList<>();
		}
		
		courses.add(tempCourse);
		tempCourse.setInstructor(this);
	}
	
	public instructorDetail() {
		
	}
	
	
	
	
	
	
}
