package com.exam.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Covidtest {
	@Id
	int id;
	String name;
	String phone;
	Date date;
	String result;
	String fee;
	
	
	
	public Covidtest() {
		super();
	}



	public Covidtest(int id, String name, String phone, Date date, String result, String fee) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.date = date;
		this.result = result;
		this.fee = fee;
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



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public String getFee() {
		return fee;
	}



	public void setFee(String fee) {
		this.fee = fee;
	}
	
	
	

}


