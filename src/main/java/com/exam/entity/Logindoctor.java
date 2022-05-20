package com.exam.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Logindoctor {
	@Id
	int id;
	String name;
	String email;
	String password;
	String image;
	
	
	public Logindoctor(int id, String name, String email, String password, String image) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.image = image;
	}


	public Logindoctor() {
		super();
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Logindoctor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", image="
				+ image + "]";
	}
	
	
	

}


