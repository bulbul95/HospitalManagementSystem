package com.exam.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Addmedicine {
	@Id
	int id;
	String name;
	Double price;
	
	
	public Addmedicine() {
		super();
	}


	public Addmedicine(int id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	
	

}


