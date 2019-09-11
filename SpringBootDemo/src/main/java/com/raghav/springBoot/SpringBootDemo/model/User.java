package com.raghav.springBoot.SpringBootDemo.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	private int id;
	
	@Size(min = 2, max = 100, message = "name should must be in 2 to 100 charecters only !!!")
	private String name;
	
	@Past
	private Date dob;
	
	public User() {
		super();
	}

	public User(int id, String name, Date dob) {
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	
}
