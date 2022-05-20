package com.exam.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	int departmentId;
	String departmentName;
	String departmentStatus;
	
	
	public Department() {
		super();
	}


	public Department(int departmentId, String departmentName, String departmentStatus) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentStatus = departmentStatus;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getDepartmentStatus() {
		return departmentStatus;
	}


	public void setDepartmentStatus(String departmentStatus) {
		this.departmentStatus = departmentStatus;
	}
	
	
	

}
