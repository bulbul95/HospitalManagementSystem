package com.exam.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Invoice {
	@Id
	int invoiceId;
	String patientName;
	String age;
	String phone;
	String address;
	String referenceDoctor;
	String billingAddress;
	Date invoiceDate;
	String bedCharge;
	String medecineCharge;
	String pathologyCharge;
	String subTotal;
	String discount;
	String grandTotal;
	String paymentMethod;
	
	
	public Invoice() {
		super();
	}


	public Invoice(int invoiceId, String patientName, String age, String phone, String address, String referenceDoctor,
			String billingAddress, Date invoiceDate, String bedCharge, String medecineCharge, String pathologyCharge,
			String subTotal, String discount, String grandTotal, String paymentMethod) {
		super();
		this.invoiceId = invoiceId;
		this.patientName = patientName;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.referenceDoctor = referenceDoctor;
		this.billingAddress = billingAddress;
		this.invoiceDate = invoiceDate;
		this.bedCharge = bedCharge;
		this.medecineCharge = medecineCharge;
		this.pathologyCharge = pathologyCharge;
		this.subTotal = subTotal;
		this.discount = discount;
		this.grandTotal = grandTotal;
		this.paymentMethod = paymentMethod;
	}


	public int getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getReferenceDoctor() {
		return referenceDoctor;
	}


	public void setReferenceDoctor(String referenceDoctor) {
		this.referenceDoctor = referenceDoctor;
	}


	public String getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}


	public Date getInvoiceDate() {
		return invoiceDate;
	}


	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}


	public String getBedCharge() {
		return bedCharge;
	}


	public void setBedCharge(String bedCharge) {
		this.bedCharge = bedCharge;
	}


	public String getMedecineCharge() {
		return medecineCharge;
	}


	public void setMedecineCharge(String medecineCharge) {
		this.medecineCharge = medecineCharge;
	}


	public String getPathologyCharge() {
		return pathologyCharge;
	}


	public void setPathologyCharge(String pathologyCharge) {
		this.pathologyCharge = pathologyCharge;
	}


	public String getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}


	public String getDiscount() {
		return discount;
	}


	public void setDiscount(String discount) {
		this.discount = discount;
	}


	public String getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", patientName=" + patientName + ", age=" + age + ", phone=" + phone
				+ ", address=" + address + ", referenceDoctor=" + referenceDoctor + ", billingAddress=" + billingAddress
				+ ", invoiceDate=" + invoiceDate + ", bedCharge=" + bedCharge + ", medecineCharge=" + medecineCharge
				+ ", pathologyCharge=" + pathologyCharge + ", subTotal=" + subTotal + ", discount=" + discount
				+ ", grandTotal=" + grandTotal + ", paymentMethod=" + paymentMethod + "]";
	}
	
	
	
	

}
