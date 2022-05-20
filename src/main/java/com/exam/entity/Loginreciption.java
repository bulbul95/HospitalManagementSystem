package com.exam.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Loginreciption {
	@Id
	int id;
	String name;
	String password;
	
	
	
	public Loginreciption() {
		super();
	}



	public Loginreciption(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
