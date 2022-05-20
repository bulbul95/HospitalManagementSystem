package com.exam.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Appoinment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int appoinmentId;
	String patientName;
	String patientAge;
	String patientPhone;
	String doctorName;
	String doctorEmail;
	String department;
	Date date;
    String time;
    String status;
    
    
	public Appoinment() {
		super();
	}


	public Appoinment(int appoinmentId, String patientName, String patientAge, String patientPhone, String doctorName,
			String doctorEmail, String department, Date date, String time, String status) {
		super();
		this.appoinmentId = appoinmentId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientPhone = patientPhone;
		this.doctorName = doctorName;
		this.doctorEmail = doctorEmail;
		this.department = department;
		this.date = date;
		this.time = time;
		this.status = status;
	}


	public int getAppoinmentId() {
		return appoinmentId;
	}


	public void setAppoinmentId(int appoinmentId) {
		this.appoinmentId = appoinmentId;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getPatientAge() {
		return patientAge;
	}


	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}


	public String getPatientPhone() {
		return patientPhone;
	}


	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public String getDoctorEmail() {
		return doctorEmail;
	}


	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	
	
	
	

}
