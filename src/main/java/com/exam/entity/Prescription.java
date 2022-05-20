package com.exam.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Prescription {
	@Id
	int prescriptionId;
	String patientName;
	String age;
	Date date;
	String pathology1;
	String medecine1;
	String M;
	String A;
	String N;
	String pathology2;
	String medecine2;
	String M1;
	String A1;
	String N1;
	String doctorName;
	
	
	
	public Prescription() {
		super();
	}



	public Prescription(int prescriptionId, String patientName, String age, Date date, String pathology1,
			String medecine1, String m, String a, String n, String pathology2, String medecine2, String m1, String a1,
			String n1, String doctorName) {
		super();
		this.prescriptionId = prescriptionId;
		this.patientName = patientName;
		this.age = age;
		this.date = date;
		this.pathology1 = pathology1;
		this.medecine1 = medecine1;
		M = m;
		A = a;
		N = n;
		this.pathology2 = pathology2;
		this.medecine2 = medecine2;
		M1 = m1;
		A1 = a1;
		N1 = n1;
		this.doctorName = doctorName;
	}



	public int getPrescriptionId() {
		return prescriptionId;
	}



	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}



	public String getPatientName() {
		return patientName;
	}



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getPathology1() {
		return pathology1;
	}



	public void setPathology1(String pathology1) {
		this.pathology1 = pathology1;
	}



	public String getMedecine1() {
		return medecine1;
	}



	public void setMedecine1(String medecine1) {
		this.medecine1 = medecine1;
	}



	public String getM() {
		return M;
	}



	public void setM(String m) {
		M = m;
	}



	public String getA() {
		return A;
	}



	public void setA(String a) {
		A = a;
	}



	public String getN() {
		return N;
	}



	public void setN(String n) {
		N = n;
	}



	public String getPathology2() {
		return pathology2;
	}



	public void setPathology2(String pathology2) {
		this.pathology2 = pathology2;
	}



	public String getMedecine2() {
		return medecine2;
	}



	public void setMedecine2(String medecine2) {
		this.medecine2 = medecine2;
	}



	public String getM1() {
		return M1;
	}



	public void setM1(String m1) {
		M1 = m1;
	}



	public String getA1() {
		return A1;
	}



	public void setA1(String a1) {
		A1 = a1;
	}



	public String getN1() {
		return N1;
	}



	public void setN1(String n1) {
		N1 = n1;
	}



	public String getDoctorName() {
		return doctorName;
	}



	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	
	
	

}
