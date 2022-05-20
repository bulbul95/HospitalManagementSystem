package com.exam.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patholgy {
	@Id
	int id;
	String name;
	String descripton;
	
	
//	public Ptholgy() {
//		super();
//	}
//
//
//	public Ptholgy(int id, String name, String descripton) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.descripton = descripton;
//	}


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


	public String getDescripton() {
		return descripton;
	}


	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	
	
	

}
