package com.jajodia.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="student_info")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="full_name",nullable=false)
	private String fullName;
	
	@Column(name="stream",nullable=false)
	private String stream;
	
	@Column(name="st_email")
	@Email(message="Please Enter email in correct format")
	private String email;
	
	@Column(name="st_contact")
	@NotNull
	private String contactNumber;
	
	@Column(name="fees")
	private boolean fees;
	
	
	public Student() {
		super();
	}

	public Student(String fullName, String stream,
			@Email(message = "Please Enter email in correct format") String email, @NotNull String contactNumber,
			boolean fees) {
		super();
		this.fullName = fullName;
		this.stream = stream;
		this.email = email;
		this.contactNumber = contactNumber;
		this.fees = fees;
	}



	public boolean isFees() {
		return fees;
	}


	public void setFees(boolean fees) {
		this.fees = fees;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	

}
