package com.example.springDataJPAUsingGradle.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class StudentEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id of the student", name = "id", value = "12345", required = true)
	private long id;
	
	@NotBlank(message="Name cannot be empty")
	@Length(min = 3, message="Length of name should be greater than or equal to 3")
	@ApiModelProperty(notes = "Name of the student", name = "name", value = "John", required = true)
	private String name; // mandatory
	
	@NotBlank(message = "Course name cannot be empty")
	@ApiModelProperty(notes = "Course of the student", name = "course", value = "Java", required = true)
	private String course;
	
	@ApiModelProperty(notes = "Currently active or inactive", name = "active", value = "true/false")
	private boolean active=true;
	
	@NotBlank(message = "Phone number cannot be empty")
	@Pattern(regexp = "^[0-9]{10}", message = "Phone number should be 10 Digits with no characters")
	@ApiModelProperty(notes = "Phone number of the student", name = "phoneNumber", value = "1234567890", required = true)
	private String phoneNumber;
	
	// phone number(10 digits)
	
	protected StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentEntity(String name, String course) {
		super();
		this.name = name;
		this.course = course;
		this.active = true;
	}

	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", active=" + active + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
}
