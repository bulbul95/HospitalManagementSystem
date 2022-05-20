package com.exam.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Addpatient {
	@Id
	int patientId;
	String patientName;
	String patientAddress;
	String patientMobile;
	String patientAge;
	String patientDisease;
	String referenceDoctor;
	String department;
	Date admittedDate;
	
	
	
	public Addpatient() {
		super();
	}



	public Addpatient(int patientId, String patientName, String patientAddress, String patientMobile, String patientAge,
			String patientDisease, String referenceDoctor, String department, Date admittedDate) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAddress = patientAddress;
		this.patientMobile = patientMobile;
		this.patientAge = patientAge;
		this.patientDisease = patientDisease;
		this.referenceDoctor = referenceDoctor;
		this.department = department;
		this.admittedDate = admittedDate;
	}



	public int getPatientId() {
		return patientId;
	}



	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}



	public String getPatientName() {
		return patientName;
	}



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	public String getPatientAddress() {
		return patientAddress;
	}



	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}



	public String getPatientMobile() {
		return patientMobile;
	}



	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}



	public String getPatientAge() {
		return patientAge;
	}



	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}



	public String getPatientDisease() {
		return patientDisease;
	}



	public void setPatientDisease(String patientDisease) {
		this.patientDisease = patientDisease;
	}



	public String getReferenceDoctor() {
		return referenceDoctor;
	}



	public void setReferenceDoctor(String referenceDoctor) {
		this.referenceDoctor = referenceDoctor;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public Date getAdmittedDate() {
		return admittedDate;
	}



	public void setAdmittedDate(Date admittedDate) {
		this.admittedDate = admittedDate;
	}
	
	
	

}


