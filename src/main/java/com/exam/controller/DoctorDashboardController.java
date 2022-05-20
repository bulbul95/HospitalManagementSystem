package com.exam.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.exam.dataaccess.Dao;
import com.exam.dataaccess.DoctorDataAccess;
import com.exam.dataaccess.RecieptionDataAccess;
import com.exam.entity.Adddoctor;
import com.exam.entity.Addpatient;
import com.exam.entity.Appoinment;
import com.exam.entity.Department;
import com.exam.entity.Loginadmin;
import com.exam.entity.Logindoctor;
import com.exam.entity.Loginpathology;
import com.exam.entity.Prescription;

@Controller
public class DoctorDashboardController {

@RequestMapping("/logindoctor")	
public String logindoctor() {
	
	return "logformdoctor";
}


@RequestMapping("/logoutdoctor")	
public String logoutdoctor() {
	
	return "userrole";
}


@RequestMapping("/profiledoctor")	
public String profiledoor() {
	
	return "doctorprofile";
	
}




@RequestMapping("/profiledoctorprofile")
public String profiledoctorprofile(Model m) {

	    List<Adddoctor> lis;
		Dao dao = new Dao();
		lis =dao.doShowdoctor();
		m.addAttribute("dctrrofile", lis);
	
	return "profiledoctoDoctorprofile";

}











@RequestMapping(value = "/logindoctor", method = RequestMethod.POST)
public String logindoctor(@ModelAttribute("Logindoctor") Logindoctor logindoctor, Model m) {
      DoctorDataAccess dao = new DoctorDataAccess();
	String log = "";
	

	try {
		String st = dao.doctorLogin(logindoctor.getName(), logindoctor.getPassword());
		if ("Success".equals(st)) {
		
			List<Appoinment>lis;
		    lis=dao.doShowDoctorAppnment();
		    m.addAttribute("ap", lis);

			log = "doctordashboard";

		} else {
			m.addAttribute("alert", "Id is wrong");
			log = "logformdoctor";
		}
	} catch (Exception e) {

		System.out.println(e);
	}
	return log;
}

  

                                         





                                /*---doctorview part--*/



@RequestMapping("/doctrview")	
public String doctrview(Model m) {
	 List<Adddoctor> lis;
	Dao dao = new Dao();
	 lis=dao.doShowdoctor();
	 m.addAttribute("doctrr", lis);
	
	return "doctorviewalldoctor";
	
}




@RequestMapping("/makePrscption")	
public String makePrscption(@ModelAttribute()Appoinment appoinment,Model m) {
	List<Appoinment> lis;
	DoctorDataAccess dao = new DoctorDataAccess();
	lis=dao.doShowprescptionAppnment(appoinment);
	m.addAttribute("ap", lis);
	
	
	int x = dao.getprescriptionID();
	m.addAttribute("id", x+1);
	
return "prescription";
	
}




@RequestMapping("/inserprscrption")
	public String insertpatient(@ModelAttribute() Prescription prescription, Model m) {
	
		DoctorDataAccess dao = new DoctorDataAccess();
		dao.doInsertPrescption(prescription);
		m.addAttribute("p", prescription);
		
		return "prescriptionreport";

	}




@RequestMapping("/smsDoctor")
public String smsDoctor() {

	
	
	return "DoctorChat";

}



@RequestMapping("/doctpatnts")
public String doctpatnts(Model m) {

	DoctorDataAccess dao = new DoctorDataAccess();
	List<Addpatient>lis;
	lis=dao.Showdoctorpatint();
	m.addAttribute("p", lis);
	
	return "doctorpatient";

}









@RequestMapping("/doctorinserprscrption")
public String doctorinserprscrption(@ModelAttribute() Prescription prescription, Model m) {

	DoctorDataAccess dao = new DoctorDataAccess();
	dao.doInsertPrescption(prescription);
	m.addAttribute("p", prescription);
	
	return "doctorprescriptionreport";

}






@RequestMapping("/allprescription")
public String allprescription(@ModelAttribute() Prescription prescription, Model m) {

	DoctorDataAccess dao = new DoctorDataAccess();
	List<Prescription>lis;
	lis=dao.ShowDoctorAllprescription();
	m.addAttribute("p", lis);
	
	return "doctorAllprescription";

}





@RequestMapping("/searchPrescription")
public String searchPrescription(@ModelAttribute() Prescription prescription, Model m) {
	DoctorDataAccess dao = new DoctorDataAccess();
	m.addAttribute("p", dao.searchDoctorPrescription(prescription.getDoctorName()));
	System.out.println(prescription.getDoctorName());
	return "doctorAllprescription";
}







@RequestMapping("/showPrescription")
public String showPrescription(@ModelAttribute() Prescription prescription, Model m) {
	DoctorDataAccess dao = new DoctorDataAccess();
	List<Prescription>lis;
	lis=dao.viewDoctorprescription(prescription);
	m.addAttribute("pp", lis);
	
	return "doctorviewPrescription";
}




@RequestMapping("/doctoDoctorpro")
public String doctrprofle(Model m) {

	    List<Adddoctor> lis;
		Dao dao = new Dao();
		lis =dao.doShowdoctor();
		m.addAttribute("dctrrofile", lis);
	
	return "doctordoctorprofile";

}







@RequestMapping("/deletePrscrption")
public String deletePrscrption(@ModelAttribute() Prescription prescription, Model m) {

	DoctorDataAccess dao = new DoctorDataAccess();
	dao.doDeletprscription(prescription);
	List<Prescription>lis;
	lis=dao.ShowDoctorAllprescription();
	m.addAttribute("p", lis);
	
	return "doctorAllprescription";

}




@RequestMapping("/doctdashbord")
public String doctdashbord(Model m) {
	DoctorDataAccess dao = new DoctorDataAccess();
	List<Appoinment>lis;
    lis=dao.doShowDoctorAppnment();
    m.addAttribute("ap", lis);

	  
	return "doctordashboard";

}







@RequestMapping("/makpatintprecrption")
public String makpatintprecrption(@ModelAttribute()Addpatient addpatient,Model m) {
	DoctorDataAccess dao= new DoctorDataAccess();
	int x =dao.getprescriptionID();
	m.addAttribute("id", x+1);
	
	List<Addpatient>lis;
	lis=dao.Showdoctorpatint2(addpatient);
    m.addAttribute("pp", lis);
	  
	return "doctorpatntprescrption";

}








}
