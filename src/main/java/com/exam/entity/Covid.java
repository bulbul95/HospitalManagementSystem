package com.exam.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Covid {
	@Id
	int covidId;
	String covidName;
	String covidEmail;
	String covidPhone;
	Date covidDate;
	String covidMessage;
	String covidStatus;
	
	
	public Covid() {
		super();
	}


	public Covid(int covidId, String covidName, String covidEmail, String covidPhone, Date covidDate,
			String covidMessage, String covidStatus) {
		super();
		this.covidId = covidId;
		this.covidName = covidName;
		this.covidEmail = covidEmail;
		this.covidPhone = covidPhone;
		this.covidDate = covidDate;
		this.covidMessage = covidMessage;
		this.covidStatus = covidStatus;
	}


	public int getCovidId() {
		return covidId;
	}


	public void setCovidId(int covidId) {
		this.covidId = covidId;
	}


	public String getCovidName() {
		return covidName;
	}


	public void setCovidName(String covidName) {
		this.covidName = covidName;
	}


	public String getCovidEmail() {
		return covidEmail;
	}


	public void setCovidEmail(String covidEmail) {
		this.covidEmail = covidEmail;
	}


	public String getCovidPhone() {
		return covidPhone;
	}


	public void setCovidPhone(String covidPhone) {
		this.covidPhone = covidPhone;
	}


	public Date getCovidDate() {
		return covidDate;
	}


	public void setCovidDate(Date covidDate) {
		this.covidDate = covidDate;
	}


	public String getCovidMessage() {
		return covidMessage;
	}


	public void setCovidMessage(String covidMessage) {
		this.covidMessage = covidMessage;
	}


	public String getCovidStatus() {
		return covidStatus;
	}


	public void setCovidStatus(String covidStatus) {
		this.covidStatus = covidStatus;
	}


	@Override
	public String toString() {
		return "Covid [covidId=" + covidId + ", covidName=" + covidName + ", covidEmail=" + covidEmail + ", covidPhone="
				+ covidPhone + ", covidDate=" + covidDate + ", covidMessage=" + covidMessage + ", covidStatus="
				+ covidStatus + "]";
	}

	
	
	
	
	
}
