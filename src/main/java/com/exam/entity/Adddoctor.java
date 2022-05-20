package com.exam.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adddoctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int doctorId;
	String doctorName;
	String doctorGender;
	String doctorDepartment;
	String doctorEmail;
	String doctorUserName;
	String doctorPassword;
	Date doctorJoin;
	String doctorImage;
	
	
	public Adddoctor() {
		super();
	}


	public Adddoctor(int doctorId, String doctorName, String doctorGender, String doctorDepartment, String doctorEmail,
			String doctorUserName, String doctorPassword, Date doctorJoin, String doctorImage) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorGender = doctorGender;
		this.doctorDepartment = doctorDepartment;
		this.doctorEmail = doctorEmail;
		this.doctorUserName = doctorUserName;
		this.doctorPassword = doctorPassword;
		this.doctorJoin = doctorJoin;
		this.doctorImage = doctorImage;
	}


	public int getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public String getDoctorGender() {
		return doctorGender;
	}


	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}


	public String getDoctorDepartment() {
		return doctorDepartment;
	}


	public void setDoctorDepartment(String doctorDepartment) {
		this.doctorDepartment = doctorDepartment;
	}


	public String getDoctorEmail() {
		return doctorEmail;
	}


	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}


	public String getDoctorUserName() {
		return doctorUserName;
	}


	public void setDoctorUserName(String doctorUserName) {
		this.doctorUserName = doctorUserName;
	}


	public String getDoctorPassword() {
		return doctorPassword;
	}


	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}


	public Date getDoctorJoin() {
		return doctorJoin;
	}


	public void setDoctorJoin(Date doctorJoin) {
		this.doctorJoin = doctorJoin;
	}


	public String getDoctorImage() {
		return doctorImage;
	}


	public void setDoctorImage(String doctorImage) {
		this.doctorImage = doctorImage;
	}
	
	

}


