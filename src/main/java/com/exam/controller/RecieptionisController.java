package com.exam.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.exam.dataaccess.AdminDataaccess;
import com.exam.dataaccess.Dao;
import com.exam.dataaccess.FarmacyDataAccess;
import com.exam.dataaccess.RecieptionDataAccess;
import com.exam.entity.Adddoctor;
import com.exam.entity.Addpatient;
import com.exam.entity.Appoinment;
import com.exam.entity.Covid;
import com.exam.entity.Department;
import com.exam.entity.Invoice;
import com.exam.entity.Loginfarmacy;
import com.exam.entity.Loginreciption;

@Controller
public class RecieptionisController {

	 @RequestMapping(value="/loginreciption", method = RequestMethod.POST)
	  public String logreciption(Model m) {
		
		  
		return "logformrecition";
		
	}
	 
	 
	 
	 @RequestMapping("/reciptondashbord")
	  public String reciptondashbord(Model m) {
		
		  
		return "reciptiondashboard";
		
	}
	 
	 @RequestMapping("/sms")
	  public String sms(Model m) {
		   List<Adddoctor> lis;
			Dao dao = new Dao();
			lis =dao.doShowdoctor();
			m.addAttribute("sms", lis);
		  
		  
		return "chatreciptiondoctor";
		
	}
	 
	 
	 
	 
	 
	 @RequestMapping("reciptionprofile")
	  public String reciptionprofile() {
		  
		  
		return "profilereciptionist";
		
	}
	 
	
	 
	 
	 
	 @RequestMapping("/reciponcovid")
	  public String reciptioncovid(Model m) {
		 List<Covid> lis;
		  Dao dao= new Dao();
		 lis= dao.doShowCovid();
		 m.addAttribute("cvid", lis);
		  
		  
		return "reciptioncovidappointments";
		
	}
	 

	
	
	 @RequestMapping("/reciptiondoctorprofile")
		public String reciptiondoctorprofile(Model m) {

			    List<Adddoctor> lis;
				Dao dao = new Dao();
				lis =dao.doShowdoctor();
				m.addAttribute("recprofile", lis);
			
			return "reciptiondoctors";

		}
	 
	 
	 @RequestMapping("/doctrprofle")
		public String doctrprofle(Model m) {

			    List<Adddoctor> lis;
				Dao dao = new Dao();
				lis =dao.doShowdoctor();
				m.addAttribute("dctrrofile", lis);
			
			return "profilereciptionistdoctor";

		}
	 
	 

	 
	 @RequestMapping("/patnts")
		public String patnts(Model m) {

			    List<Addpatient> lis;
				RecieptionDataAccess dao = new RecieptionDataAccess();
				lis =dao.Showpatint();
				m.addAttribute("psnt", lis);
			
			return "reciptionpatients";

		}
	 
	 
	 
	 
	 @RequestMapping("/addptnt")
		public String  addptnt(Model m) {
		        List<Department> list;
			    List<Addpatient> lis;
			    List<Adddoctor> listt;
				RecieptionDataAccess dao = new RecieptionDataAccess();
				Dao da = new Dao();
				lis =dao.Showpatint();
				list=dao.doShowDepatmnt();
			    listt=da.doShowdoctor();
			    int x =dao.getpatientID();
				m.addAttribute("psnt", lis);
				m.addAttribute("dptmnt", list);
				m.addAttribute("dctrr", listt);
				m.addAttribute("xx",x+1);
				
				
				
			
			return "reciption-add-patient";

		}
	 
	 
	
	 

	 
	 
	 
	 
	 
	 
	  
	  @RequestMapping(value ="/loginretion", method = RequestMethod.POST)
			public String loginrecipton(@ModelAttribute() Loginreciption lgin, Model m) {
		   RecieptionDataAccess dao = new RecieptionDataAccess();
				Dao da=new Dao();
				if (dao.loginRecipion(lgin) == 1) {
					  
					
					  List<Adddoctor> lis;
					  List<Appoinment> list;
					  List<Invoice> listt;
					  List<Addpatient> listtt;
					  List<Appoinment> ap;
					  
					  
					  lis =da.doShowdoctor();
					  m.addAttribute("doc", lis);
					  
					  
					  list=dao.doShowAppnment();
					  m.addAttribute("ap", list);
					  
					  listtt=dao.Showpatint();
					  m.addAttribute("paa", listtt);
					  
					  listt=dao.ShowInvoice();
					  m.addAttribute("in", listt);
					  
					  
					  ap=dao.doShowAppnment();
					  m.addAttribute("apnmt", ap);
					  
					  
					return "reciptiondashboard";

				} else {
					return "logformrecition";
				}

			}
	  
	  
	  
	  
	  
	  @RequestMapping("/insertpatient")
		public String insertpatient(@ModelAttribute() Addpatient addpatient, Model m) {
		
			RecieptionDataAccess dao = new RecieptionDataAccess();
			dao.doInsertPatient(addpatient);
			
			return "reciption-add-patient";

		}
	  
	  
	 
		
	  @RequestMapping("/deleteptnt")
		public String deltpatient(@ModelAttribute() Addpatient addpatient, Model m) {
		    List<Addpatient> lis;
			RecieptionDataAccess dao = new RecieptionDataAccess();
			dao.doDeletepatint(addpatient);
			lis =dao.Showpatint();
			m.addAttribute("psnt", lis);
			return"reciptionpatients";
		}
		
	  
	  @RequestMapping("/updatefpatnt")
		public String updatee(@ModelAttribute() Addpatient addpatient, Model m) {
		
			m.addAttribute("uppatient",addpatient);
			
			return"reciption-update-patient";
		}
	  
	  
	  @RequestMapping("/updatepatint")
		public String update1(@ModelAttribute() Addpatient addpatient, Model m) {
			RecieptionDataAccess dao = new RecieptionDataAccess();
			dao.doUpdatpatint(addpatient);
			  List<Addpatient> lis;
			  lis =dao.Showpatint();
				m.addAttribute("psnt", lis);
				return"reciptionpatients";
		
		}
	  
	  @RequestMapping("/approveCovid")
		public String approveCovid(@ModelAttribute() Covid covid, Model m) {
		  List<Covid> lis;
			RecieptionDataAccess dao = new RecieptionDataAccess();
			dao.doApproveCovid(covid);
			lis=dao.doShowApprovedCovid();
			m.addAttribute("cvid", lis);
			return"reciptioncovidappointments";
		} 
	  
	  
	  
	  
	  
	  @RequestMapping("/recptiondeptmnt")
		public String recptiondeptmnt(@ModelAttribute() Department department, Model m) {
		  List<Department> lis;
		  AdminDataaccess dao = new AdminDataaccess();
			lis=dao.doShowDepartment();
			m.addAttribute("deprtmnt", lis);
			
			return"receptiondepartments";
		}
	  
	 
	  
	  @RequestMapping("/invoicc")
		public String invoicc(Model m) {

			    List<Addpatient> lis;
				RecieptionDataAccess dao = new RecieptionDataAccess();
				lis =dao.Showpatint();
				m.addAttribute("psnt", lis);
			
			return "reciptionpInvoiceCreate";

		}
	  
	  
	  
	  
	  @RequestMapping("/createInvoice")
			public String createInvoice(@ModelAttribute() Addpatient addpatient, Model m) {
				RecieptionDataAccess dao = new RecieptionDataAccess();
		
				  List<Addpatient> lis;
				  lis =dao.Showpatintofinvoic(addpatient);
				  int x = dao.getinvoiceID();
					m.addAttribute("psnt", lis);
					m.addAttribute("id",x+1);
					return"recipton-create-invoice";
			
			}
	  
	 
	 
	  
	  
	  @RequestMapping("/inserInvoice")
		public String inserInvoice(@ModelAttribute() Invoice invoice, Model m) {
		
			RecieptionDataAccess dao = new RecieptionDataAccess();
			dao.doInsertInvoice(invoice);
			m.addAttribute("inv", invoice);
			
			
			return "reciption-invoice-view";

		}
	  
	  
	  
	  @RequestMapping("/inviceView")
		public String inviceView( Model m) {
			RecieptionDataAccess dao = new RecieptionDataAccess();
			 List<Invoice> lis;
			lis=dao.ShowInvoice();
			m.addAttribute("inv", lis);
			 
				return"reciptionInvoicView";
		
		}
	  
	  
	  
	  
	  @RequestMapping("/deleteInvoie")
		public String deleteInvoie(@ModelAttribute() Invoice invoice, Model m) {
			RecieptionDataAccess dao = new RecieptionDataAccess();
	           dao.doDeleteInvoice(invoice);
	           List<Invoice> lis;
				lis=dao.ShowInvoice();
				m.addAttribute("inv", lis);
		
				return"reciptionInvoicView";
		
		}
	  
	  
	  
	  
	  
	  @RequestMapping("/updatefInvoice")
			public String updatefInvoice(@ModelAttribute() Invoice invoice, Model m) {
			
				m.addAttribute("p",invoice);
				
				return"recipton-update-invoice";
			}
	  
	  
	  

	  @RequestMapping("/updateInvoice")
		public String updateInvoice(@ModelAttribute() Invoice invoice, Model m) {
			RecieptionDataAccess dao = new RecieptionDataAccess();
			dao.doUpdatInvic(invoice);
			  List<Invoice> lis;
			  lis =dao.ShowInvoice();
				m.addAttribute("inv", lis);
				return"reciptionInvoicView";
		
		}
	  
	  
	  
	  

		@RequestMapping("/appointmentShow")
		public String 	appointmentApprve(Model m) {
			  List<Appoinment> lis;
		     RecieptionDataAccess dao = new RecieptionDataAccess();
		  
		      lis=dao.doShowAppnment();
              m.addAttribute("apnmt", lis);
		      return "reciptionistappointmentshow";

		}
		
		
		
		  @RequestMapping("/updateAppnmnt")
			public String updateAppnmnt(@ModelAttribute() Appoinment appoinment, Model m) {
				RecieptionDataAccess dao = new RecieptionDataAccess();
				dao.doUpdatAppoinment(appoinment);
				  List<Appoinment> lis;
				  lis =dao.doShowAppnment();
					m.addAttribute("apnmt", lis);
					return"reciptionistappointmentshow";
			
			}
		  
		  
		  
		  

			@RequestMapping("/adddApppnment")
			public String addApppnment(Model m) {
				RecieptionDataAccess dao = new RecieptionDataAccess();
				Dao da= new Dao();
				  List<Appoinment> lis;
				  List<Department> list;
				  List<Adddoctor> listt;
				  
				 list=dao.doShowDepartmentName();
				 m.addAttribute("dn", list);
					
				 
				listt= da.doShowdoctor();
				m.addAttribute("doc", listt);
				 
			      int x = dao.getappnmentID();
				  m.addAttribute("id", x+1);
					  
					
			      return "reciption-add-appointment";

			}
			
		
		  
		
			
			
			  @RequestMapping("/saveAppnmnet")
				public String saveAppnmnet(@ModelAttribute() Appoinment appoinment, Model m) {
					RecieptionDataAccess dao = new RecieptionDataAccess();
					dao.doInsertAppnnment(appoinment);
					  List<Appoinment> lis;
					  lis =dao.doShowAppnment();
						m.addAttribute("apnmt", lis);
						return"reciptionistappointmentshow";
				
				}
			  
		
		
			  

				@RequestMapping("/reciptionsms")
				public String reciptionsms(Model m) {
					
					
					
				      return "reciptionSMS";

				}
				
			  
		
		
		
	  
	  

}
