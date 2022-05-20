package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exam.dataaccess.DoctorDataAccess;
import com.exam.dataaccess.PatientDataAccess;
import com.exam.dataaccess.RecieptionDataAccess;
import com.exam.entity.Adddoctor;
import com.exam.entity.Addpatient;
import com.exam.entity.Invoice;
import com.exam.entity.Loginpatient;
import com.exam.entity.Loginreciption;
import com.exam.entity.Prescription;
import com.exam.repository.AddPatientRepository;

@Controller
public class PatientController {
	@Autowired
	AddPatientRepository addPatientR;
	
	
	
	
	
	
	
	
	@RequestMapping("/loginpatient")
	public String loginpatient() {
		
		return "patientdashboard";
		
		
		
	}
	
	
	
	  @RequestMapping(value ="/loginpatient", method = RequestMethod.POST)
		public String loginrecipton(@ModelAttribute() Loginpatient lgin, Model m) {
	    PatientDataAccess dao = new PatientDataAccess();
			
		if (dao.loginPatient(lgin) == 1) {
			
				return "patientdashboard";

			} else {
				return "logformpatient";
			}
		  
		}
	
	  
	  
	  
		
		  @RequestMapping("/viewPatientInvoice") public String
		  viewInvoice(@ModelAttribute() Invoice invoice, Model m) {
		  
		  PatientDataAccess dao = new PatientDataAccess(); m.addAttribute("in",
		  dao.searchPatientInvoice(invoice.getInvoiceId()));
		  
		  
		  return "patient-invoice-report"; }
		   
	



@RequestMapping("/viewPatientPrscription")
public String viewPatientPrscription(@ModelAttribute() Prescription prescription, Model m) {
	
	PatientDataAccess dao = new PatientDataAccess();
	  m.addAttribute("pp", dao.searchDoctorPrescription(prescription.getPrescriptionId()));
	 
	
	return "patientprescriptionreport";
} 
	  





@RequestMapping("/patientdashbord")
public String patientdashbord() {
	
	return "patientdashboard";
} 


}
